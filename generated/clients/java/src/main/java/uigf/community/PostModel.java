package uigf.community;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import uigf.CommunityUser;
import uigf.JsonObject;

/**
 * The PostModel model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class PostModel implements JsonSerializable<PostModel> {
    /*
     * The post_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String postId;

    /*
     * The subject property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String subject;

    /*
     * The content property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String content;

    /*
     * The created_at property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Long createdAt;

    /*
     * The user property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private CommunityUser user;

    /*
     * The images property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private List<JsonObject> images;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of PostModel class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private PostModel() {
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
     * Get the subject property: The subject property.
     * 
     * @return the subject value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSubject() {
        return this.subject;
    }

    /**
     * Get the content property: The content property.
     * 
     * @return the content value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getContent() {
        return this.content;
    }

    /**
     * Get the createdAt property: The created_at property.
     * 
     * @return the createdAt value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Long getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Get the user property: The user property.
     * 
     * @return the user value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CommunityUser getUser() {
        return this.user;
    }

    /**
     * Get the images property: The images property.
     * 
     * @return the images value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<JsonObject> getImages() {
        return this.images;
    }

    /**
     * Get the additionalProperties property: Additional properties.
     * 
     * @return the additionalProperties value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Map<String, BinaryData> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("post_id", this.postId);
        jsonWriter.writeStringField("subject", this.subject);
        jsonWriter.writeStringField("content", this.content);
        jsonWriter.writeNumberField("created_at", this.createdAt);
        jsonWriter.writeJsonField("user", this.user);
        jsonWriter.writeArrayField("images", this.images, (writer, element) -> writer.writeJson(element));
        if (additionalProperties != null) {
            for (Map.Entry<String, BinaryData> additionalProperty : additionalProperties.entrySet()) {
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
     * Reads an instance of PostModel from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PostModel if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the PostModel.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static PostModel fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PostModel deserializedPostModel = new PostModel();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("post_id".equals(fieldName)) {
                    deserializedPostModel.postId = reader.getString();
                } else if ("subject".equals(fieldName)) {
                    deserializedPostModel.subject = reader.getString();
                } else if ("content".equals(fieldName)) {
                    deserializedPostModel.content = reader.getString();
                } else if ("created_at".equals(fieldName)) {
                    deserializedPostModel.createdAt = reader.getNullable(JsonReader::getLong);
                } else if ("user".equals(fieldName)) {
                    deserializedPostModel.user = CommunityUser.fromJson(reader);
                } else if ("images".equals(fieldName)) {
                    List<JsonObject> images = reader.readArray(reader1 -> JsonObject.fromJson(reader1));
                    deserializedPostModel.images = images;
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedPostModel.additionalProperties = additionalProperties;

            return deserializedPostModel;
        });
    }
}
