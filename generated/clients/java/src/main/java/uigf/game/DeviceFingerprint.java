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
 * The DeviceFingerprint model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class DeviceFingerprint implements JsonSerializable<DeviceFingerprint> {
    /*
     * The device_fp property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String deviceFp;

    /*
     * The code property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer code;

    /*
     * The msg property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String msg;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of DeviceFingerprint class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private DeviceFingerprint() {
    }

    /**
     * Get the deviceFp property: The device_fp property.
     * 
     * @return the deviceFp value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getDeviceFp() {
        return this.deviceFp;
    }

    /**
     * Get the code property: The code property.
     * 
     * @return the code value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getCode() {
        return this.code;
    }

    /**
     * Get the msg property: The msg property.
     * 
     * @return the msg value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMsg() {
        return this.msg;
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
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("device_fp", this.deviceFp);
        jsonWriter.writeNumberField("code", this.code);
        jsonWriter.writeStringField("msg", this.msg);
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
     * Reads an instance of DeviceFingerprint from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeviceFingerprint if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DeviceFingerprint.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static DeviceFingerprint fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DeviceFingerprint deserializedDeviceFingerprint = new DeviceFingerprint();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("device_fp".equals(fieldName)) {
                    deserializedDeviceFingerprint.deviceFp = reader.getString();
                } else if ("code".equals(fieldName)) {
                    deserializedDeviceFingerprint.code = reader.getNullable(JsonReader::getInt);
                } else if ("msg".equals(fieldName)) {
                    deserializedDeviceFingerprint.msg = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedDeviceFingerprint.additionalProperties = additionalProperties;

            return deserializedDeviceFingerprint;
        });
    }
}
