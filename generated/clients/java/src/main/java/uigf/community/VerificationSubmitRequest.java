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
 * The VerificationSubmitRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class VerificationSubmitRequest implements JsonSerializable<VerificationSubmitRequest> {
    /*
     * The challenge property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String challenge;

    /*
     * The validate property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String validate;

    /*
     * The seccode property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String seccode;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of VerificationSubmitRequest class.
     * 
     * @param challenge the challenge value to set.
     * @param validate the validate value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public VerificationSubmitRequest(String challenge, String validate) {
        this.challenge = challenge;
        this.validate = validate;
    }

    /**
     * Get the challenge property: The challenge property.
     * 
     * @return the challenge value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getChallenge() {
        return this.challenge;
    }

    /**
     * Get the validate property: The validate property.
     * 
     * @return the validate value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getValidate() {
        return this.validate;
    }

    /**
     * Get the seccode property: The seccode property.
     * 
     * @return the seccode value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSeccode() {
        return this.seccode;
    }

    /**
     * Set the seccode property: The seccode property.
     * 
     * @param seccode the seccode value to set.
     * @return the VerificationSubmitRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public VerificationSubmitRequest setSeccode(String seccode) {
        this.seccode = seccode;
        return this;
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
     * @return the VerificationSubmitRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public VerificationSubmitRequest setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
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
        jsonWriter.writeStringField("challenge", this.challenge);
        jsonWriter.writeStringField("validate", this.validate);
        jsonWriter.writeStringField("seccode", this.seccode);
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
     * Reads an instance of VerificationSubmitRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VerificationSubmitRequest if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the VerificationSubmitRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static VerificationSubmitRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String challenge = null;
            String validate = null;
            String seccode = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("challenge".equals(fieldName)) {
                    challenge = reader.getString();
                } else if ("validate".equals(fieldName)) {
                    validate = reader.getString();
                } else if ("seccode".equals(fieldName)) {
                    seccode = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            VerificationSubmitRequest deserializedVerificationSubmitRequest
                = new VerificationSubmitRequest(challenge, validate);
            deserializedVerificationSubmitRequest.seccode = seccode;
            deserializedVerificationSubmitRequest.additionalProperties = additionalProperties;

            return deserializedVerificationSubmitRequest;
        });
    }
}
