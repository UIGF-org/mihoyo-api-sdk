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
 * The VerificationCreateRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class VerificationCreateRequest implements JsonSerializable<VerificationCreateRequest> {
    /*
     * The action_type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String actionType;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of VerificationCreateRequest class.
     * 
     * @param actionType the actionType value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public VerificationCreateRequest(String actionType) {
        this.actionType = actionType;
    }

    /**
     * Get the actionType property: The action_type property.
     * 
     * @return the actionType value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getActionType() {
        return this.actionType;
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
     * @return the VerificationCreateRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public VerificationCreateRequest setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
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
        jsonWriter.writeStringField("action_type", this.actionType);
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
     * Reads an instance of VerificationCreateRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VerificationCreateRequest if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the VerificationCreateRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static VerificationCreateRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String actionType = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("action_type".equals(fieldName)) {
                    actionType = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            VerificationCreateRequest deserializedVerificationCreateRequest = new VerificationCreateRequest(actionType);
            deserializedVerificationCreateRequest.additionalProperties = additionalProperties;

            return deserializedVerificationCreateRequest;
        });
    }
}
