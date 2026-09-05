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
import java.util.List;
import java.util.Map;

/**
 * The ShopGoods model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ShopGoods implements JsonSerializable<ShopGoods> {
    /*
     * The goods_list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<ShopGood> goodsList;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of ShopGoods class.
     * 
     * @param goodsList the goodsList value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private ShopGoods(List<ShopGood> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * Get the goodsList property: The goods_list property.
     * 
     * @return the goodsList value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<ShopGood> getGoodsList() {
        return this.goodsList;
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
        jsonWriter.writeArrayField("goods_list", this.goodsList, (writer, element) -> writer.writeJson(element));
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
     * Reads an instance of ShopGoods from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ShopGoods if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ShopGoods.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ShopGoods fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            List<ShopGood> goodsList = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("goods_list".equals(fieldName)) {
                    goodsList = reader.readArray(reader1 -> ShopGood.fromJson(reader1));
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            ShopGoods deserializedShopGoods = new ShopGoods(goodsList);
            deserializedShopGoods.additionalProperties = additionalProperties;

            return deserializedShopGoods;
        });
    }
}
