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
 * The MobileCaptchaLoginRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class MobileCaptchaLoginRequest extends DeviceContext {
    /*
     * The mobile property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String mobile;

    /*
     * The mobile_captcha property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String mobileCaptcha;

    /*
     * The action_ticket property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String actionTicket;

    /*
     * The game_biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String gameBiz;

    /**
     * Creates an instance of MobileCaptchaLoginRequest class.
     * 
     * @param device the device value to set.
     * @param mobile the mobile value to set.
     * @param mobileCaptcha the mobileCaptcha value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public MobileCaptchaLoginRequest(String device, String mobile, String mobileCaptcha) {
        super(device);
        this.mobile = mobile;
        this.mobileCaptcha = mobileCaptcha;
    }

    /**
     * Get the mobile property: The mobile property.
     * 
     * @return the mobile value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Get the mobileCaptcha property: The mobile_captcha property.
     * 
     * @return the mobileCaptcha value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMobileCaptcha() {
        return this.mobileCaptcha;
    }

    /**
     * Get the actionTicket property: The action_ticket property.
     * 
     * @return the actionTicket value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getActionTicket() {
        return this.actionTicket;
    }

    /**
     * Set the actionTicket property: The action_ticket property.
     * 
     * @param actionTicket the actionTicket value to set.
     * @return the MobileCaptchaLoginRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public MobileCaptchaLoginRequest setActionTicket(String actionTicket) {
        this.actionTicket = actionTicket;
        return this;
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
     * @return the MobileCaptchaLoginRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public MobileCaptchaLoginRequest setGameBiz(String gameBiz) {
        this.gameBiz = gameBiz;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public MobileCaptchaLoginRequest setDeviceFp(String deviceFp) {
        super.setDeviceFp(deviceFp);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public MobileCaptchaLoginRequest setDeviceName(String deviceName) {
        super.setDeviceName(deviceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public MobileCaptchaLoginRequest setDeviceModel(String deviceModel) {
        super.setDeviceModel(deviceModel);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public MobileCaptchaLoginRequest setDeviceId(String deviceId) {
        super.setDeviceId(deviceId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public MobileCaptchaLoginRequest setAppId(String appId) {
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
        jsonWriter.writeStringField("mobile", this.mobile);
        jsonWriter.writeStringField("mobile_captcha", this.mobileCaptcha);
        jsonWriter.writeStringField("action_ticket", this.actionTicket);
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
     * Reads an instance of MobileCaptchaLoginRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MobileCaptchaLoginRequest if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MobileCaptchaLoginRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static MobileCaptchaLoginRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String device = null;
            String deviceFp = null;
            String deviceName = null;
            String deviceModel = null;
            String deviceId = null;
            String appId = null;
            String mobile = null;
            String mobileCaptcha = null;
            String actionTicket = null;
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
                } else if ("mobile".equals(fieldName)) {
                    mobile = reader.getString();
                } else if ("mobile_captcha".equals(fieldName)) {
                    mobileCaptcha = reader.getString();
                } else if ("action_ticket".equals(fieldName)) {
                    actionTicket = reader.getString();
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
            MobileCaptchaLoginRequest deserializedMobileCaptchaLoginRequest
                = new MobileCaptchaLoginRequest(device, mobile, mobileCaptcha);
            deserializedMobileCaptchaLoginRequest.setDeviceFp(deviceFp);
            deserializedMobileCaptchaLoginRequest.setDeviceName(deviceName);
            deserializedMobileCaptchaLoginRequest.setDeviceModel(deviceModel);
            deserializedMobileCaptchaLoginRequest.setDeviceId(deviceId);
            deserializedMobileCaptchaLoginRequest.setAppId(appId);
            deserializedMobileCaptchaLoginRequest.actionTicket = actionTicket;
            deserializedMobileCaptchaLoginRequest.gameBiz = gameBiz;
            deserializedMobileCaptchaLoginRequest.setAdditionalProperties(additionalProperties);

            return deserializedMobileCaptchaLoginRequest;
        });
    }
}
