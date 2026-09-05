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
 * The OrderStatus model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class OrderStatus implements JsonSerializable<OrderStatus> {
    /*
     * The status property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer status;

    /*
     * The amount property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String amount;

    /*
     * The goods_num property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String goodsNum;

    /*
     * The goods_title property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String goodsTitle;

    /*
     * The order_no property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String orderNo;

    /*
     * The pay_plat property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String payPlat;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of OrderStatus class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private OrderStatus() {
    }

    /**
     * Get the status property: The status property.
     * 
     * @return the status value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Get the amount property: The amount property.
     * 
     * @return the amount value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getAmount() {
        return this.amount;
    }

    /**
     * Get the goodsNum property: The goods_num property.
     * 
     * @return the goodsNum value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsNum() {
        return this.goodsNum;
    }

    /**
     * Get the goodsTitle property: The goods_title property.
     * 
     * @return the goodsTitle value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGoodsTitle() {
        return this.goodsTitle;
    }

    /**
     * Get the orderNo property: The order_no property.
     * 
     * @return the orderNo value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getOrderNo() {
        return this.orderNo;
    }

    /**
     * Get the payPlat property: The pay_plat property.
     * 
     * @return the payPlat value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getPayPlat() {
        return this.payPlat;
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
        jsonWriter.writeNumberField("status", this.status);
        jsonWriter.writeStringField("amount", this.amount);
        jsonWriter.writeStringField("goods_num", this.goodsNum);
        jsonWriter.writeStringField("goods_title", this.goodsTitle);
        jsonWriter.writeStringField("order_no", this.orderNo);
        jsonWriter.writeStringField("pay_plat", this.payPlat);
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
     * Reads an instance of OrderStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OrderStatus if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the OrderStatus.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static OrderStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OrderStatus deserializedOrderStatus = new OrderStatus();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("status".equals(fieldName)) {
                    deserializedOrderStatus.status = reader.getNullable(JsonReader::getInt);
                } else if ("amount".equals(fieldName)) {
                    deserializedOrderStatus.amount = reader.getString();
                } else if ("goods_num".equals(fieldName)) {
                    deserializedOrderStatus.goodsNum = reader.getString();
                } else if ("goods_title".equals(fieldName)) {
                    deserializedOrderStatus.goodsTitle = reader.getString();
                } else if ("order_no".equals(fieldName)) {
                    deserializedOrderStatus.orderNo = reader.getString();
                } else if ("pay_plat".equals(fieldName)) {
                    deserializedOrderStatus.payPlat = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedOrderStatus.additionalProperties = additionalProperties;

            return deserializedOrderStatus;
        });
    }
}
