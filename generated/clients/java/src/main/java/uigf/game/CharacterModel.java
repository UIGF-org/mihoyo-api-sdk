package uigf.game;

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
 * The CharacterModel model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class CharacterModel implements JsonSerializable<CharacterModel> {
    /*
     * The id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Long id;

    /*
     * The name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String name;

    /*
     * The level property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer level;

    /*
     * The image property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String image;

    /*
     * The icon property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String icon;

    /*
     * The rarity property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer rarity;

    /*
     * The element property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String element;

    /*
     * The fetter property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer fetter;

    /*
     * The actived_constellation_num property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer activedConstellationNum;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of CharacterModel class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private CharacterModel() {
    }

    /**
     * Get the id property: The id property.
     * 
     * @return the id value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Long getId() {
        return this.id;
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
     * Get the level property: The level property.
     * 
     * @return the level value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getLevel() {
        return this.level;
    }

    /**
     * Get the image property: The image property.
     * 
     * @return the image value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getImage() {
        return this.image;
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
     * Get the rarity property: The rarity property.
     * 
     * @return the rarity value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getRarity() {
        return this.rarity;
    }

    /**
     * Get the element property: The element property.
     * 
     * @return the element value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getElement() {
        return this.element;
    }

    /**
     * Get the fetter property: The fetter property.
     * 
     * @return the fetter value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getFetter() {
        return this.fetter;
    }

    /**
     * Get the activedConstellationNum property: The actived_constellation_num property.
     * 
     * @return the activedConstellationNum value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getActivedConstellationNum() {
        return this.activedConstellationNum;
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
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeNumberField("level", this.level);
        jsonWriter.writeStringField("image", this.image);
        jsonWriter.writeStringField("icon", this.icon);
        jsonWriter.writeNumberField("rarity", this.rarity);
        jsonWriter.writeStringField("element", this.element);
        jsonWriter.writeNumberField("fetter", this.fetter);
        jsonWriter.writeNumberField("actived_constellation_num", this.activedConstellationNum);
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
     * Reads an instance of CharacterModel from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CharacterModel if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the CharacterModel.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static CharacterModel fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CharacterModel deserializedCharacterModel = new CharacterModel();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedCharacterModel.id = reader.getNullable(JsonReader::getLong);
                } else if ("name".equals(fieldName)) {
                    deserializedCharacterModel.name = reader.getString();
                } else if ("level".equals(fieldName)) {
                    deserializedCharacterModel.level = reader.getNullable(JsonReader::getInt);
                } else if ("image".equals(fieldName)) {
                    deserializedCharacterModel.image = reader.getString();
                } else if ("icon".equals(fieldName)) {
                    deserializedCharacterModel.icon = reader.getString();
                } else if ("rarity".equals(fieldName)) {
                    deserializedCharacterModel.rarity = reader.getNullable(JsonReader::getInt);
                } else if ("element".equals(fieldName)) {
                    deserializedCharacterModel.element = reader.getString();
                } else if ("fetter".equals(fieldName)) {
                    deserializedCharacterModel.fetter = reader.getNullable(JsonReader::getInt);
                } else if ("actived_constellation_num".equals(fieldName)) {
                    deserializedCharacterModel.activedConstellationNum = reader.getNullable(JsonReader::getInt);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedCharacterModel.additionalProperties = additionalProperties;

            return deserializedCharacterModel;
        });
    }
}
