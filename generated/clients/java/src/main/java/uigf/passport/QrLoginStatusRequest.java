package uigf.passport;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The QrLoginStatusRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class QrLoginStatusRequest extends DeviceContext {
    /*
     * The ticket property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String ticket;

    /*
     * The app_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String appId;

    /**
     * Creates an instance of QrLoginStatusRequest class.
     * 
     * @param device the device value to set.
     * @param ticket the ticket value to set.
     * @param appId the appId value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public QrLoginStatusRequest(String device, String ticket, String appId) {
        super(device);
        this.ticket = ticket;
        this.appId = appId;
    }

    /**
     * Get the ticket property: The ticket property.
     * 
     * @return the ticket value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getTicket() {
        return this.ticket;
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
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public QrLoginStatusRequest setDeviceFp(String deviceFp) {
        super.setDeviceFp(deviceFp);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public QrLoginStatusRequest setDeviceName(String deviceName) {
        super.setDeviceName(deviceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public QrLoginStatusRequest setDeviceModel(String deviceModel) {
        super.setDeviceModel(deviceModel);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public QrLoginStatusRequest setDeviceId(String deviceId) {
        super.setDeviceId(deviceId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("device", getDevice());
        jsonWriter.writeStringField("device_fp", getDeviceFp());
        jsonWriter.writeStringField("device_name", getDeviceName());
        jsonWriter.writeStringField("device_model", getDeviceModel());
        jsonWriter.writeStringField("device_id", getDeviceId());
        jsonWriter.writeStringField("ticket", this.ticket);
        jsonWriter.writeStringField("app_id", this.appId);
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, BinaryData> additionalProperty : getAdditionalProperties().entrySet()) {
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
     * Reads an instance of QrLoginStatusRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of QrLoginStatusRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the QrLoginStatusRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static QrLoginStatusRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String device = null;
            String deviceFp = null;
            String deviceName = null;
            String deviceModel = null;
            String deviceId = null;
            String ticket = null;
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
                } else if ("ticket".equals(fieldName)) {
                    ticket = reader.getString();
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
            QrLoginStatusRequest deserializedQrLoginStatusRequest = new QrLoginStatusRequest(device, ticket, appId);
            deserializedQrLoginStatusRequest.setDeviceFp(deviceFp);
            deserializedQrLoginStatusRequest.setDeviceName(deviceName);
            deserializedQrLoginStatusRequest.setDeviceModel(deviceModel);
            deserializedQrLoginStatusRequest.setDeviceId(deviceId);
            deserializedQrLoginStatusRequest.setAdditionalProperties(additionalProperties);

            return deserializedQrLoginStatusRequest;
        });
    }
}
