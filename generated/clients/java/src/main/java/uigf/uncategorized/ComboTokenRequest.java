package uigf.uncategorized;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The ComboTokenRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ComboTokenRequest implements JsonSerializable<ComboTokenRequest> {
    /*
     * The biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String biz;

    /**
     * Creates an instance of ComboTokenRequest class.
     * 
     * @param biz the biz value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ComboTokenRequest(String biz) {
        this.biz = biz;
    }

    /**
     * Get the biz property: The biz property.
     * 
     * @return the biz value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getBiz() {
        return this.biz;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("biz", this.biz);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ComboTokenRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ComboTokenRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ComboTokenRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ComboTokenRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String biz = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("biz".equals(fieldName)) {
                    biz = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new ComboTokenRequest(biz);
        });
    }
}
