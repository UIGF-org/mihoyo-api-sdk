package uigf.passport;

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
 * The DeviceContext model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public class DeviceContext implements JsonSerializable<DeviceContext> {
    /*
     * The device property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String device;

    /*
     * The device_fp property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String deviceFp;

    /*
     * The device_name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String deviceName;

    /*
     * The device_model property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String deviceModel;

    /*
     * The device_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String deviceId;

    /*
     * The app_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String appId;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of DeviceContext class.
     * 
     * @param device the device value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext(String device) {
        this.device = device;
    }

    /**
     * Get the device property: The device property.
     * 
     * @return the device value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getDevice() {
        return this.device;
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
     * Set the deviceFp property: The device_fp property.
     * 
     * @param deviceFp the deviceFp value to set.
     * @return the DeviceContext object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext setDeviceFp(String deviceFp) {
        this.deviceFp = deviceFp;
        return this;
    }

    /**
     * Get the deviceName property: The device_name property.
     * 
     * @return the deviceName value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getDeviceName() {
        return this.deviceName;
    }

    /**
     * Set the deviceName property: The device_name property.
     * 
     * @param deviceName the deviceName value to set.
     * @return the DeviceContext object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    /**
     * Get the deviceModel property: The device_model property.
     * 
     * @return the deviceModel value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getDeviceModel() {
        return this.deviceModel;
    }

    /**
     * Set the deviceModel property: The device_model property.
     * 
     * @param deviceModel the deviceModel value to set.
     * @return the DeviceContext object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
        return this;
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
     * Set the deviceId property: The device_id property.
     * 
     * @param deviceId the deviceId value to set.
     * @return the DeviceContext object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * Get the appId property: The app_id property.
     * 
     * @return the appId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getAppId() {
        return this.appId;
    }

    /**
     * Set the appId property: The app_id property.
     * 
     * @param appId the appId value to set.
     * @return the DeviceContext object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext setAppId(String appId) {
        this.appId = appId;
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
     * @return the DeviceContext object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DeviceContext setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
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
        jsonWriter.writeStringField("device", this.device);
        jsonWriter.writeStringField("device_fp", this.deviceFp);
        jsonWriter.writeStringField("device_name", this.deviceName);
        jsonWriter.writeStringField("device_model", this.deviceModel);
        jsonWriter.writeStringField("device_id", this.deviceId);
        jsonWriter.writeStringField("app_id", this.appId);
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
     * Reads an instance of DeviceContext from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeviceContext if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DeviceContext.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static DeviceContext fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String device = null;
            String deviceFp = null;
            String deviceName = null;
            String deviceModel = null;
            String deviceId = null;
            String appId = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("device".equals(fieldName)) {
                    device = reader.getString();
                } else if ("device_fp".equals(fieldName)) {
                    deviceFp = reader.getString();
                } else if ("device_name".equals(fieldName)) {
                    deviceName = reader.getString();
                } else if ("device_model".equals(fieldName)) {
                    deviceModel = reader.getString();
                } else if ("device_id".equals(fieldName)) {
                    deviceId = reader.getString();
                } else if ("app_id".equals(fieldName)) {
                    appId = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            DeviceContext deserializedDeviceContext = new DeviceContext(device);
            deserializedDeviceContext.deviceFp = deviceFp;
            deserializedDeviceContext.deviceName = deviceName;
            deserializedDeviceContext.deviceModel = deviceModel;
            deserializedDeviceContext.deviceId = deviceId;
            deserializedDeviceContext.appId = appId;
            deserializedDeviceContext.additionalProperties = additionalProperties;

            return deserializedDeviceContext;
        });
    }
}
