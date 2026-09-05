package uigf.community;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The SignInRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class SignInRequest implements JsonSerializable<SignInRequest> {
    /*
     * The gids property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final int gids;

    /**
     * Creates an instance of SignInRequest class.
     * 
     * @param gids the gids value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public SignInRequest(int gids) {
        this.gids = gids;
    }

    /**
     * Get the gids property: The gids property.
     * 
     * @return the gids value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public int getGids() {
        return this.gids;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("gids", this.gids);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SignInRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SignInRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SignInRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static SignInRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            int gids = 0;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("gids".equals(fieldName)) {
                    gids = reader.getInt();
                } else {
                    reader.skipChildren();
                }
            }
            return new SignInRequest(gids);
        });
    }
}
