package uigf;

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
 * The GachaItem model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GachaItem implements JsonSerializable<GachaItem> {
    /*
     * The uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String uid;

    /*
     * The gacha_type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String gachaType;

    /*
     * The item_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String itemId;

    /*
     * The count property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String count;

    /*
     * The time property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String time;

    /*
     * The name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String name;

    /*
     * The item_type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String itemType;

    /*
     * The rank_type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String rankType;

    /*
     * The id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String id;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of GachaItem class.
     * 
     * @param id the id value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private GachaItem(String id) {
        this.id = id;
    }

    /**
     * Get the uid property: The uid property.
     * 
     * @return the uid value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getUid() {
        return this.uid;
    }

    /**
     * Get the gachaType property: The gacha_type property.
     * 
     * @return the gachaType value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGachaType() {
        return this.gachaType;
    }

    /**
     * Get the itemId property: The item_id property.
     * 
     * @return the itemId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getItemId() {
        return this.itemId;
    }

    /**
     * Get the count property: The count property.
     * 
     * @return the count value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getCount() {
        return this.count;
    }

    /**
     * Get the time property: The time property.
     * 
     * @return the time value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getTime() {
        return this.time;
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
     * Get the itemType property: The item_type property.
     * 
     * @return the itemType value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getItemType() {
        return this.itemType;
    }

    /**
     * Get the rankType property: The rank_type property.
     * 
     * @return the rankType value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getRankType() {
        return this.rankType;
    }

    /**
     * Get the id property: The id property.
     * 
     * @return the id value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getId() {
        return this.id;
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
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("uid", this.uid);
        jsonWriter.writeStringField("gacha_type", this.gachaType);
        jsonWriter.writeStringField("item_id", this.itemId);
        jsonWriter.writeStringField("count", this.count);
        jsonWriter.writeStringField("time", this.time);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("item_type", this.itemType);
        jsonWriter.writeStringField("rank_type", this.rankType);
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
     * Reads an instance of GachaItem from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GachaItem if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GachaItem.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GachaItem fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String id = null;
            String uid = null;
            String gachaType = null;
            String itemId = null;
            String count = null;
            String time = null;
            String name = null;
            String itemType = null;
            String rankType = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    id = reader.getString();
                } else if ("uid".equals(fieldName)) {
                    uid = reader.getString();
                } else if ("gacha_type".equals(fieldName)) {
                    gachaType = reader.getString();
                } else if ("item_id".equals(fieldName)) {
                    itemId = reader.getString();
                } else if ("count".equals(fieldName)) {
                    count = reader.getString();
                } else if ("time".equals(fieldName)) {
                    time = reader.getString();
                } else if ("name".equals(fieldName)) {
                    name = reader.getString();
                } else if ("item_type".equals(fieldName)) {
                    itemType = reader.getString();
                } else if ("rank_type".equals(fieldName)) {
                    rankType = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            GachaItem deserializedGachaItem = new GachaItem(id);
            deserializedGachaItem.uid = uid;
            deserializedGachaItem.gachaType = gachaType;
            deserializedGachaItem.itemId = itemId;
            deserializedGachaItem.count = count;
            deserializedGachaItem.time = time;
            deserializedGachaItem.name = name;
            deserializedGachaItem.itemType = itemType;
            deserializedGachaItem.rankType = rankType;
            deserializedGachaItem.additionalProperties = additionalProperties;

            return deserializedGachaItem;
        });
    }
}
