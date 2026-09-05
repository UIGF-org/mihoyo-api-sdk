package uigf.game;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The PandaQrRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class PandaQrRequest implements JsonSerializable<PandaQrRequest> {
    /*
     * The app_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final int appId;

    /*
     * The device property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String device;

    /*
     * The ticket property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String ticket;

    /**
     * Creates an instance of PandaQrRequest class.
     * 
     * @param appId the appId value to set.
     * @param device the device value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public PandaQrRequest(int appId, String device) {
        this.appId = appId;
        this.device = device;
    }

    /**
     * Get the appId property: The app_id property.
     * 
     * @return the appId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public int getAppId() {
        return this.appId;
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
     * Get the ticket property: The ticket property.
     * 
     * @return the ticket value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getTicket() {
        return this.ticket;
    }

    /**
     * Set the ticket property: The ticket property.
     * 
     * @param ticket the ticket value to set.
     * @return the PandaQrRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public PandaQrRequest setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("app_id", this.appId);
        jsonWriter.writeStringField("device", this.device);
        jsonWriter.writeStringField("ticket", this.ticket);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PandaQrRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PandaQrRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PandaQrRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static PandaQrRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            int appId = 0;
            String device = null;
            String ticket = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("app_id".equals(fieldName)) {
                    appId = reader.getInt();
                } else if ("device".equals(fieldName)) {
                    device = reader.getString();
                } else if ("ticket".equals(fieldName)) {
                    ticket = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            PandaQrRequest deserializedPandaQrRequest = new PandaQrRequest(appId, device);
            deserializedPandaQrRequest.ticket = ticket;

            return deserializedPandaQrRequest;
        });
    }
}
