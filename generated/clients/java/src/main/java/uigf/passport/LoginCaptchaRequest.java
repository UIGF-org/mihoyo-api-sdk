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
 * The LoginCaptchaRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class LoginCaptchaRequest extends DeviceContext {
    /*
     * The action_type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String actionType;

    /*
     * The game_biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String gameBiz;

    /**
     * Creates an instance of LoginCaptchaRequest class.
     * 
     * @param device the device value to set.
     * @param actionType the actionType value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public LoginCaptchaRequest(String device, String actionType) {
        super(device);
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
     * Get the gameBiz property: The game_biz property.
     * 
     * @return the gameBiz value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameBiz() {
        return this.gameBiz;
    }

    /**
     * Set the gameBiz property: The game_biz property.
     * 
     * @param gameBiz the gameBiz value to set.
     * @return the LoginCaptchaRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public LoginCaptchaRequest setGameBiz(String gameBiz) {
        this.gameBiz = gameBiz;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public LoginCaptchaRequest setDeviceFp(String deviceFp) {
        super.setDeviceFp(deviceFp);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public LoginCaptchaRequest setDeviceName(String deviceName) {
        super.setDeviceName(deviceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public LoginCaptchaRequest setDeviceModel(String deviceModel) {
        super.setDeviceModel(deviceModel);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public LoginCaptchaRequest setDeviceId(String deviceId) {
        super.setDeviceId(deviceId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public LoginCaptchaRequest setAppId(String appId) {
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
        jsonWriter.writeStringField("action_type", this.actionType);
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
     * Reads an instance of LoginCaptchaRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LoginCaptchaRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LoginCaptchaRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static LoginCaptchaRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String device = null;
            String deviceFp = null;
            String deviceName = null;
            String deviceModel = null;
            String deviceId = null;
            String appId = null;
            String actionType = null;
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
                } else if ("action_type".equals(fieldName)) {
                    actionType = reader.getString();
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
            LoginCaptchaRequest deserializedLoginCaptchaRequest = new LoginCaptchaRequest(device, actionType);
            deserializedLoginCaptchaRequest.setDeviceFp(deviceFp);
            deserializedLoginCaptchaRequest.setDeviceName(deviceName);
            deserializedLoginCaptchaRequest.setDeviceModel(deviceModel);
            deserializedLoginCaptchaRequest.setDeviceId(deviceId);
            deserializedLoginCaptchaRequest.setAppId(appId);
            deserializedLoginCaptchaRequest.gameBiz = gameBiz;
            deserializedLoginCaptchaRequest.setAdditionalProperties(additionalProperties);

            return deserializedLoginCaptchaRequest;
        });
    }
}
