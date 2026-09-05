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
import java.util.Map;

/**
 * The Forum model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class Forum implements JsonSerializable<Forum> {
    /*
     * The id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer id;

    /*
     * The game_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer gameId;

    /*
     * The name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String name;

    /*
     * The icon property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String icon;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of Forum class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Forum() {
    }

    /**
     * Get the id property: The id property.
     * 
     * @return the id value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getId() {
        return this.id;
    }

    /**
     * Get the gameId property: The game_id property.
     * 
     * @return the gameId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getGameId() {
        return this.gameId;
    }

    /**
     * Get the name property: The name property.
     * 
     * @return the name value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getName() {
        return this.name;
    }

    /**
     * Get the icon property: The icon property.
     * 
     * @return the icon value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getIcon() {
        return this.icon;
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
        jsonWriter.writeNumberField("id", this.id);
        jsonWriter.writeNumberField("game_id", this.gameId);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("icon", this.icon);
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
     * Reads an instance of Forum from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Forum if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the Forum.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static Forum fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Forum deserializedForum = new Forum();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedForum.id = reader.getNullable(JsonReader::getInt);
                } else if ("game_id".equals(fieldName)) {
                    deserializedForum.gameId = reader.getNullable(JsonReader::getInt);
                } else if ("name".equals(fieldName)) {
                    deserializedForum.name = reader.getString();
                } else if ("icon".equals(fieldName)) {
                    deserializedForum.icon = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedForum.additionalProperties = additionalProperties;

            return deserializedForum;
        });
    }
}
