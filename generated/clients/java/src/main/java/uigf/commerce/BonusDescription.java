package uigf.commerce;

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
 * The BonusDescription model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class BonusDescription implements JsonSerializable<BonusDescription> {
    /*
     * The bonus_desc property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String bonusDesc;

    /*
     * The bonus_unit property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer bonusUnit;

    /*
     * The bonus_goods_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String bonusGoodsId;

    /*
     * The bonus_icon property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String bonusIcon;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of BonusDescription class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private BonusDescription() {
    }

    /**
     * Get the bonusDesc property: The bonus_desc property.
     * 
     * @return the bonusDesc value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getBonusDesc() {
        return this.bonusDesc;
    }

    /**
     * Get the bonusUnit property: The bonus_unit property.
     * 
     * @return the bonusUnit value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getBonusUnit() {
        return this.bonusUnit;
    }

    /**
     * Get the bonusGoodsId property: The bonus_goods_id property.
     * 
     * @return the bonusGoodsId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getBonusGoodsId() {
        return this.bonusGoodsId;
    }

    /**
     * Get the bonusIcon property: The bonus_icon property.
     * 
     * @return the bonusIcon value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getBonusIcon() {
        return this.bonusIcon;
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
        jsonWriter.writeStringField("bonus_desc", this.bonusDesc);
        jsonWriter.writeNumberField("bonus_unit", this.bonusUnit);
        jsonWriter.writeStringField("bonus_goods_id", this.bonusGoodsId);
        jsonWriter.writeStringField("bonus_icon", this.bonusIcon);
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
     * Reads an instance of BonusDescription from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BonusDescription if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the BonusDescription.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static BonusDescription fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BonusDescription deserializedBonusDescription = new BonusDescription();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("bonus_desc".equals(fieldName)) {
                    deserializedBonusDescription.bonusDesc = reader.getString();
                } else if ("bonus_unit".equals(fieldName)) {
                    deserializedBonusDescription.bonusUnit = reader.getNullable(JsonReader::getInt);
                } else if ("bonus_goods_id".equals(fieldName)) {
                    deserializedBonusDescription.bonusGoodsId = reader.getString();
                } else if ("bonus_icon".equals(fieldName)) {
                    deserializedBonusDescription.bonusIcon = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedBonusDescription.additionalProperties = additionalProperties;

            return deserializedBonusDescription;
        });
    }
}
