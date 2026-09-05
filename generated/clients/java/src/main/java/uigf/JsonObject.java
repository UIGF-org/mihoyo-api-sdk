package uigf;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A JSON object whose vendor-defined properties are preserved by generated clients.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class JsonObject implements JsonSerializable<JsonObject> {
    /*
     * A JSON object whose vendor-defined properties are preserved by generated clients.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of JsonObject class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject() {
    }

    /**
     * Get the additionalProperties property: A JSON object whose vendor-defined properties are preserved by generated
     * clients.
     * 
     * @return the additionalProperties value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Map<String, BinaryData> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: A JSON object whose vendor-defined properties are preserved by generated
     * clients.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the JsonObject object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (additionalProperties != null) {
            for (Map.Entry<String, BinaryData> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeFieldName(additionalProperty.getKey());
                if (additionalProperty.getValue() == null) {
                    jsonWriter.writeNull();
                } else {
                    additionalProperty.getValue().writeTo(jsonWriter);
                }
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of JsonObject from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of JsonObject if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the JsonObject.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static JsonObject fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            JsonObject deserializedJsonObject = new JsonObject();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if (additionalProperties == null) {
                    additionalProperties = new LinkedHashMap<>();
                }

                additionalProperties.put(fieldName,
                    reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
            }
            deserializedJsonObject.additionalProperties = additionalProperties;

            return deserializedJsonObject;
        });
    }
}
