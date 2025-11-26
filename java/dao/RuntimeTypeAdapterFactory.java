package dao;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Permet de gérer la sérialisation/désérialisation polymorphique avec Gson.
 * Exemple d’utilisation :
 * RuntimeTypeAdapterFactory<Vehicule> factory = RuntimeTypeAdapterFactory
 *      .of(Vehicule.class, "type")
 *      .registerSubtype(Moto.class, "Moto")
 *      .registerSubtype(Camion.class, "Camion")
 *      .registerSubtype(Velo.class, "Velo")
 *      .registerSubtype(Bus.class, "Bus");
 *
 * Gson gson = new GsonBuilder().registerTypeAdapterFactory(factory).create();
 */
public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final Class<?> baseType;
    private final String typeFieldName;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap<>();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap<>();

    private RuntimeTypeAdapterFactory(Class<?> baseType, String typeFieldName) {
        this.baseType = baseType;
        this.typeFieldName = typeFieldName;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
        return new RuntimeTypeAdapterFactory<>(baseType, typeFieldName);
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> subtype, String label) {
        if (labelToSubtype.containsKey(label) || subtypeToLabel.containsKey(subtype)) {
            throw new IllegalArgumentException("Subtype ou label déjà enregistré.");
        }
        labelToSubtype.put(label, subtype);
        subtypeToLabel.put(subtype, label);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
        if (!baseType.isAssignableFrom(type.getRawType())) {
            return null;
        }

        final Map<String, TypeAdapter<?>> labelToDelegate = new LinkedHashMap<>();
        final Map<Class<?>, TypeAdapter<?>> subtypeToDelegate = new LinkedHashMap<>();

        for (Map.Entry<String, Class<?>> entry : labelToSubtype.entrySet()) {
            TypeAdapter<?> delegate = gson.getDelegateAdapter(this, TypeToken.get(entry.getValue()));
            labelToDelegate.put(entry.getKey(), delegate);
            subtypeToDelegate.put(entry.getValue(), delegate);
        }

        return new TypeAdapter<R>() {
            @Override
            public void write(JsonWriter out, R value) throws IOException {
                Class<?> srcClass = value.getClass();
                String label = subtypeToLabel.get(srcClass);
                if (label == null) {
                    throw new JsonParseException("Classe non enregistrée : " + srcClass.getName());
                }
                TypeAdapter<R> delegate = (TypeAdapter<R>) subtypeToDelegate.get(srcClass);
                JsonObject obj = delegate.toJsonTree(value).getAsJsonObject();
                obj.addProperty(typeFieldName, label);
                Streams.write(obj, out);
            }

            @Override
            public R read(JsonReader in) throws IOException {
                JsonElement jsonElement = Streams.parse(in);
                JsonObject obj = jsonElement.getAsJsonObject();
                JsonElement labelJson = obj.remove(typeFieldName);
                if (labelJson == null) {
                    throw new JsonParseException("Champ type manquant : " + typeFieldName);
                }
                String label = labelJson.getAsString();
                TypeAdapter<R> delegate = (TypeAdapter<R>) labelToDelegate.get(label);
                if (delegate == null) {
                    throw new JsonParseException("Label inconnu : " + label);
                }
                return delegate.fromJsonTree(obj);
            }
        };
    }
}
