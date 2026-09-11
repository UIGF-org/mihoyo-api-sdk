package uigf.game.genshin.sdk;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The GranterLoginRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GranterLoginRequest implements JsonSerializable<GranterLoginRequest> {
    /*
     * The app_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String appId;

    /*
     * The channel_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String channelId;

    /*
     * The data property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String data;

    /*
     * The device property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String device;

    /*
     * The sign property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String sign;

    /**
     * Creates an instance of GranterLoginRequest class.
     * 
     * @param appId the appId value to set.
     * @param channelId the channelId value to set.
     * @param data the data value to set.
     * @param device the device value to set.
     * @param sign the sign value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GranterLoginRequest(String appId, String channelId, String data, String device, String sign) {
        this.appId = appId;
        this.channelId = channelId;
        this.data = data;
        this.device = device;
        this.sign = sign;
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
     * Get the channelId property: The channel_id property.
     * 
     * @return the channelId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getChannelId() {
        return this.channelId;
    }

    /**
     * Get the data property: The data property.
     * 
     * @return the data value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getData() {
        return this.data;
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
     * Get the sign property: The sign property.
     * 
     * @return the sign value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSign() {
        return this.sign;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("app_id", this.appId);
        jsonWriter.writeStringField("channel_id", this.channelId);
        jsonWriter.writeStringField("data", this.data);
        jsonWriter.writeStringField("device", this.device);
        jsonWriter.writeStringField("sign", this.sign);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GranterLoginRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GranterLoginRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GranterLoginRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GranterLoginRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String appId = null;
            String channelId = null;
            String data = null;
            String device = null;
            String sign = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("app_id".equals(fieldName)) {
                    appId = reader.getString();
                } else if ("channel_id".equals(fieldName)) {
                    channelId = reader.getString();
                } else if ("data".equals(fieldName)) {
                    data = reader.getString();
                } else if ("device".equals(fieldName)) {
                    device = reader.getString();
                } else if ("sign".equals(fieldName)) {
                    sign = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new GranterLoginRequest(appId, channelId, data, device, sign);
        });
    }
}
