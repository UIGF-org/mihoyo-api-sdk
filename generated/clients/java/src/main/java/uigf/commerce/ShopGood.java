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
 * The ShopGood model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ShopGood implements JsonSerializable<ShopGood> {
    /*
     * The goods_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String goodsId;

    /*
     * The goods_name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String goodsName;

    /*
     * The goods_type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String goodsType;

    /*
     * The goods_unit property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String goodsUnit;

    /*
     * The goods_icon property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String goodsIcon;

    /*
     * The currency property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String currency;

    /*
     * The price property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String price;

    /*
     * The symbol property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String symbol;

    /*
     * The tier_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String tierId;

    /*
     * The bonus_desc property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private BonusDescription bonusDesc;

    /*
     * The once_bonus_desc property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private BonusDescription onceBonusDesc;

    /*
     * The available property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Boolean available;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of ShopGood class.
     * 
     * @param goodsId the goodsId value to set.
     * @param goodsName the goodsName value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private ShopGood(String goodsId, String goodsName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
    }

    /**
     * Get the goodsId property: The goods_id property.
     * 
     * @return the goodsId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * Get the goodsName property: The goods_name property.
     * 
     * @return the goodsName value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsName() {
        return this.goodsName;
    }

    /**
     * Get the goodsType property: The goods_type property.
     * 
     * @return the goodsType value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsType() {
        return this.goodsType;
    }

    /**
     * Get the goodsUnit property: The goods_unit property.
     * 
     * @return the goodsUnit value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsUnit() {
        return this.goodsUnit;
    }

    /**
     * Get the goodsIcon property: The goods_icon property.
     * 
     * @return the goodsIcon value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsIcon() {
        return this.goodsIcon;
    }

    /**
     * Get the currency property: The currency property.
     * 
     * @return the currency value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Get the price property: The price property.
     * 
     * @return the price value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getPrice() {
        return this.price;
    }

    /**
     * Get the symbol property: The symbol property.
     * 
     * @return the symbol value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Get the tierId property: The tier_id property.
     * 
     * @return the tierId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getTierId() {
        return this.tierId;
    }

    /**
     * Get the bonusDesc property: The bonus_desc property.
     * 
     * @return the bonusDesc value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public BonusDescription getBonusDesc() {
        return this.bonusDesc;
    }

    /**
     * Get the onceBonusDesc property: The once_bonus_desc property.
     * 
     * @return the onceBonusDesc value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public BonusDescription getOnceBonusDesc() {
        return this.onceBonusDesc;
    }

    /**
     * Get the available property: The available property.
     * 
     * @return the available value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Boolean isAvailable() {
        return this.available;
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
        jsonWriter.writeStringField("goods_id", this.goodsId);
        jsonWriter.writeStringField("goods_name", this.goodsName);
        jsonWriter.writeStringField("goods_type", this.goodsType);
        jsonWriter.writeStringField("goods_unit", this.goodsUnit);
        jsonWriter.writeStringField("goods_icon", this.goodsIcon);
        jsonWriter.writeStringField("currency", this.currency);
        jsonWriter.writeStringField("price", this.price);
        jsonWriter.writeStringField("symbol", this.symbol);
        jsonWriter.writeStringField("tier_id", this.tierId);
        jsonWriter.writeJsonField("bonus_desc", this.bonusDesc);
        jsonWriter.writeJsonField("once_bonus_desc", this.onceBonusDesc);
        jsonWriter.writeBooleanField("available", this.available);
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
     * Reads an instance of ShopGood from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ShopGood if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ShopGood.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ShopGood fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String goodsId = null;
            String goodsName = null;
            String goodsType = null;
            String goodsUnit = null;
            String goodsIcon = null;
            String currency = null;
            String price = null;
            String symbol = null;
            String tierId = null;
            BonusDescription bonusDesc = null;
            BonusDescription onceBonusDesc = null;
            Boolean available = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("goods_id".equals(fieldName)) {
                    goodsId = reader.getString();
                } else if ("goods_name".equals(fieldName)) {
                    goodsName = reader.getString();
                } else if ("goods_type".equals(fieldName)) {
                    goodsType = reader.getString();
                } else if ("goods_unit".equals(fieldName)) {
                    goodsUnit = reader.getString();
                } else if ("goods_icon".equals(fieldName)) {
                    goodsIcon = reader.getString();
                } else if ("currency".equals(fieldName)) {
                    currency = reader.getString();
                } else if ("price".equals(fieldName)) {
                    price = reader.getString();
                } else if ("symbol".equals(fieldName)) {
                    symbol = reader.getString();
                } else if ("tier_id".equals(fieldName)) {
                    tierId = reader.getString();
                } else if ("bonus_desc".equals(fieldName)) {
                    bonusDesc = BonusDescription.fromJson(reader);
                } else if ("once_bonus_desc".equals(fieldName)) {
                    onceBonusDesc = BonusDescription.fromJson(reader);
                } else if ("available".equals(fieldName)) {
                    available = reader.getNullable(JsonReader::getBoolean);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            ShopGood deserializedShopGood = new ShopGood(goodsId, goodsName);
            deserializedShopGood.goodsType = goodsType;
            deserializedShopGood.goodsUnit = goodsUnit;
            deserializedShopGood.goodsIcon = goodsIcon;
            deserializedShopGood.currency = currency;
            deserializedShopGood.price = price;
            deserializedShopGood.symbol = symbol;
            deserializedShopGood.tierId = tierId;
            deserializedShopGood.bonusDesc = bonusDesc;
            deserializedShopGood.onceBonusDesc = onceBonusDesc;
            deserializedShopGood.available = available;
            deserializedShopGood.additionalProperties = additionalProperties;

            return deserializedShopGood;
        });
    }
}
