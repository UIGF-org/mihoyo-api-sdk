package uigf.uncategorized;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The H5LogRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class H5LogRequest implements JsonSerializable<H5LogRequest> {
    /*
     * The data property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String data;

    /**
     * Creates an instance of H5LogRequest class.
     * 
     * @param data the data value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public H5LogRequest(String data) {
        this.data = data;
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
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("data", this.data);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of H5LogRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of H5LogRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the H5LogRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static H5LogRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String data = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("data".equals(fieldName)) {
                    data = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new H5LogRequest(data);
        });
    }
}
