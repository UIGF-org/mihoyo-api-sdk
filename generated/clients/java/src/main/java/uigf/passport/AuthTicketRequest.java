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
 * The AuthTicketRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class AuthTicketRequest extends DeviceContext {
    /*
     * The game_biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameBiz;

    /**
     * Creates an instance of AuthTicketRequest class.
     * 
     * @param device the device value to set.
     * @param gameBiz the gameBiz value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public AuthTicketRequest(String device, String gameBiz) {
        super(device);
        this.gameBiz = gameBiz;
    }

    /**
     * Get the gameBiz property: The game_biz property.
     * 
     * @return the gameBiz value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameBiz() {
        return this.gameBiz;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public AuthTicketRequest setDeviceFp(String deviceFp) {
        super.setDeviceFp(deviceFp);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public AuthTicketRequest setDeviceName(String deviceName) {
        super.setDeviceName(deviceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public AuthTicketRequest setDeviceModel(String deviceModel) {
        super.setDeviceModel(deviceModel);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public AuthTicketRequest setDeviceId(String deviceId) {
        super.setDeviceId(deviceId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public AuthTicketRequest setAppId(String appId) {
        super.setAppId(appId);
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
        jsonWriter.writeStringField("app_id", getAppId());
        jsonWriter.writeStringField("game_biz", this.gameBiz);
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
     * Reads an instance of AuthTicketRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AuthTicketRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AuthTicketRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static AuthTicketRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String device = null;
            String deviceFp = null;
            String deviceName = null;
            String deviceModel = null;
            String deviceId = null;
            String appId = null;
            String gameBiz = null;
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
                } else if ("game_biz".equals(fieldName)) {
                    gameBiz = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            AuthTicketRequest deserializedAuthTicketRequest = new AuthTicketRequest(device, gameBiz);
            deserializedAuthTicketRequest.setDeviceFp(deviceFp);
            deserializedAuthTicketRequest.setDeviceName(deviceName);
            deserializedAuthTicketRequest.setDeviceModel(deviceModel);
            deserializedAuthTicketRequest.setDeviceId(deviceId);
            deserializedAuthTicketRequest.setAppId(appId);
            deserializedAuthTicketRequest.setAdditionalProperties(additionalProperties);

            return deserializedAuthTicketRequest;
        });
    }
}
