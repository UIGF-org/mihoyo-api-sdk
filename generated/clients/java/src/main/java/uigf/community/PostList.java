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

/**
 * The PostList model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class PostList implements JsonSerializable<PostList> {
    /*
     * The list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private List<PostModel> list;

    /*
     * The is_last property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Boolean isLast;

    /*
     * The last_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String lastId;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of PostList class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private PostList() {
    }

    /**
     * Get the list property: The list property.
     * 
     * @return the list value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<PostModel> getList() {
        return this.list;
    }

    /**
     * Get the isLast property: The is_last property.
     * 
     * @return the isLast value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Boolean isLast() {
        return this.isLast;
    }

    /**
     * Get the lastId property: The last_id property.
     * 
     * @return the lastId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getLastId() {
        return this.lastId;
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
        jsonWriter.writeArrayField("list", this.list, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeBooleanField("is_last", this.isLast);
        jsonWriter.writeStringField("last_id", this.lastId);
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
     * Reads an instance of PostList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PostList if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the PostList.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static PostList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PostList deserializedPostList = new PostList();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("list".equals(fieldName)) {
                    List<PostModel> list = reader.readArray(reader1 -> PostModel.fromJson(reader1));
                    deserializedPostList.list = list;
                } else if ("is_last".equals(fieldName)) {
                    deserializedPostList.isLast = reader.getNullable(JsonReader::getBoolean);
                } else if ("last_id".equals(fieldName)) {
                    deserializedPostList.lastId = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedPostList.additionalProperties = additionalProperties;

            return deserializedPostList;
        });
    }
}
