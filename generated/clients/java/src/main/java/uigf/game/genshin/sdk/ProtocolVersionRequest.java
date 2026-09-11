package uigf.game.genshin.sdk;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The ProtocolVersionRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ProtocolVersionRequest implements JsonSerializable<ProtocolVersionRequest> {
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
     * The language property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String language;

    /*
     * The major property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String major;

    /*
     * The minimum property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String minimum;

    /**
     * Creates an instance of ProtocolVersionRequest class.
     * 
     * @param appId the appId value to set.
     * @param channelId the channelId value to set.
     * @param language the language value to set.
     * @param major the major value to set.
     * @param minimum the minimum value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ProtocolVersionRequest(String appId, String channelId, String language, String major, String minimum) {
        this.appId = appId;
        this.channelId = channelId;
        this.language = language;
        this.major = major;
        this.minimum = minimum;
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
     * Get the language property: The language property.
     * 
     * @return the language value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getLanguage() {
        return this.language;
    }

    /**
     * Get the major property: The major property.
     * 
     * @return the major value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMajor() {
        return this.major;
    }

    /**
     * Get the minimum property: The minimum property.
     * 
     * @return the minimum value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMinimum() {
        return this.minimum;
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
        jsonWriter.writeStringField("language", this.language);
        jsonWriter.writeStringField("major", this.major);
        jsonWriter.writeStringField("minimum", this.minimum);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ProtocolVersionRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProtocolVersionRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ProtocolVersionRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ProtocolVersionRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String appId = null;
            String channelId = null;
            String language = null;
            String major = null;
            String minimum = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("app_id".equals(fieldName)) {
                    appId = reader.getString();
                } else if ("channel_id".equals(fieldName)) {
                    channelId = reader.getString();
                } else if ("language".equals(fieldName)) {
                    language = reader.getString();
                } else if ("major".equals(fieldName)) {
                    major = reader.getString();
                } else if ("minimum".equals(fieldName)) {
                    minimum = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new ProtocolVersionRequest(appId, channelId, language, major, minimum);
        });
    }
}
