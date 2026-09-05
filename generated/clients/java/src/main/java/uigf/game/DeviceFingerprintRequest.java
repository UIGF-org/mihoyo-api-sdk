package uigf.game;

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
 * The DeviceFingerprintRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class DeviceFingerprintRequest implements JsonSerializable<DeviceFingerprintRequest> {
    /*
     * The seed_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String seedId;

    /*
     * The device_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String deviceId;

    /*
     * The platform property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String platform;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of DeviceFingerprintRequest class.
     * 
     * @param seedId the seedId value to set.
     * @param deviceId the deviceId value to set.
     * @param platform the platform value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceFingerprintRequest(String seedId, String deviceId, String platform) {
        this.seedId = seedId;
        this.deviceId = deviceId;
        this.platform = platform;
    }

    /**
     * Get the seedId property: The seed_id property.
     * 
     * @return the seedId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSeedId() {
        return this.seedId;
    }

    /**
     * Get the deviceId property: The device_id property.
     * 
     * @return the deviceId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Get the platform property: The platform property.
     * 
     * @return the platform value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getPlatform() {
        return this.platform;
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
     * @return the DeviceFingerprintRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceFingerprintRequest setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
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
        jsonWriter.writeStringField("seed_id", this.seedId);
        jsonWriter.writeStringField("device_id", this.deviceId);
        jsonWriter.writeStringField("platform", this.platform);
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
     * Reads an instance of DeviceFingerprintRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeviceFingerprintRequest if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DeviceFingerprintRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static DeviceFingerprintRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String seedId = null;
            String deviceId = null;
            String platform = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("seed_id".equals(fieldName)) {
                    seedId = reader.getString();
                } else if ("device_id".equals(fieldName)) {
                    deviceId = reader.getString();
                } else if ("platform".equals(fieldName)) {
                    platform = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            DeviceFingerprintRequest deserializedDeviceFingerprintRequest
                = new DeviceFingerprintRequest(seedId, deviceId, platform);
            deserializedDeviceFingerprintRequest.additionalProperties = additionalProperties;

            return deserializedDeviceFingerprintRequest;
        });
    }
}
