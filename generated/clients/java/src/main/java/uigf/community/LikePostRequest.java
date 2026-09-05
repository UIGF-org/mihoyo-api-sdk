package uigf.community;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The LikePostRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class LikePostRequest implements JsonSerializable<LikePostRequest> {
    /*
     * The post_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String postId;

    /*
     * The is_cancel property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final boolean isCancel;

    /**
     * Creates an instance of LikePostRequest class.
     * 
     * @param postId the postId value to set.
     * @param isCancel the isCancel value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public LikePostRequest(String postId, boolean isCancel) {
        this.postId = postId;
        this.isCancel = isCancel;
    }

    /**
     * Get the postId property: The post_id property.
     * 
     * @return the postId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getPostId() {
        return this.postId;
    }

    /**
     * Get the isCancel property: The is_cancel property.
     * 
     * @return the isCancel value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public boolean isCancel() {
        return this.isCancel;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("post_id", this.postId);
        jsonWriter.writeBooleanField("is_cancel", this.isCancel);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LikePostRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LikePostRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LikePostRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static LikePostRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String postId = null;
            boolean isCancel = false;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("post_id".equals(fieldName)) {
                    postId = reader.getString();
                } else if ("is_cancel".equals(fieldName)) {
                    isCancel = reader.getBoolean();
                } else {
                    reader.skipChildren();
                }
            }
            return new LikePostRequest(postId, isCancel);
        });
    }
}
