package uigf.community;

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
 * The LunaCheckInRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class LunaCheckInRequest implements JsonSerializable<LunaCheckInRequest> {
    /*
     * The act_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String actId;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of LunaCheckInRequest class.
     * 
     * @param actId the actId value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public LunaCheckInRequest(String actId) {
        this.actId = actId;
    }

    /**
     * Get the actId property: The act_id property.
     * 
     * @return the actId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getActId() {
        return this.actId;
    }

    /**
     * Get the additionalProperties property: Additional properties.
     * 
     * @return the additionalProperties value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Map<String, BinaryData> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Additional properties.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the LunaCheckInRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public LunaCheckInRequest setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
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
        jsonWriter.writeStringField("act_id", this.actId);
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
     * Reads an instance of LunaCheckInRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LunaCheckInRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LunaCheckInRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static LunaCheckInRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String actId = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("act_id".equals(fieldName)) {
                    actId = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            LunaCheckInRequest deserializedLunaCheckInRequest = new LunaCheckInRequest(actId);
            deserializedLunaCheckInRequest.additionalProperties = additionalProperties;

            return deserializedLunaCheckInRequest;
        });
    }
}
