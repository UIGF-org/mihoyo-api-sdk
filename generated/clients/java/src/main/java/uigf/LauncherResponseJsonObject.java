package uigf;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * Common envelope used by the HoYoPlay and Sophon APIs.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class LauncherResponseJsonObject implements JsonSerializable<LauncherResponseJsonObject> {
    /*
     * The retcode property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final int retcode;

    /*
     * The message property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String message;

    /*
     * The data property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final JsonObject data;

    /**
     * Creates an instance of LauncherResponseJsonObject class.
     * 
     * @param retcode the retcode value to set.
     * @param message the message value to set.
     * @param data the data value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private LauncherResponseJsonObject(int retcode, String message, JsonObject data) {
        this.retcode = retcode;
        this.message = message;
        this.data = data;
    }

    /**
     * Get the retcode property: The retcode property.
     * 
     * @return the retcode value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public int getRetcode() {
        return this.retcode;
    }

    /**
     * Get the message property: The message property.
     * 
     * @return the message value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMessage() {
        return this.message;
    }

    /**
     * Get the data property: The data property.
     * 
     * @return the data value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject getData() {
        return this.data;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("retcode", this.retcode);
        jsonWriter.writeStringField("message", this.message);
        jsonWriter.writeJsonField("data", this.data);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LauncherResponseJsonObject from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LauncherResponseJsonObject if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LauncherResponseJsonObject.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static LauncherResponseJsonObject fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            int retcode = 0;
            String message = null;
            JsonObject data = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("retcode".equals(fieldName)) {
                    retcode = reader.getInt();
                } else if ("message".equals(fieldName)) {
                    message = reader.getString();
                } else if ("data".equals(fieldName)) {
                    data = JsonObject.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            return new LauncherResponseJsonObject(retcode, message, data);
        });
    }
}
