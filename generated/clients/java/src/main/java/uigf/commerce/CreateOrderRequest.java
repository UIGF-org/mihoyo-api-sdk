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
import uigf.JsonObject;

/**
 * Vendor-signed order creation payload. `sign` must come from an authorized
 * official client or payment integration; this SDK intentionally does not
 * implement signing or retain payment secrets.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class CreateOrderRequest implements JsonSerializable<CreateOrderRequest> {
    /*
     * The open_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String openId;

    /*
     * The special_info property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String specialInfo;

    /*
     * The order property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final JsonObject order;

    /*
     * The sign property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String sign;

    /*
     * Vendor-signed order creation payload. `sign` must come from an authorized
     * official client or payment integration; this SDK intentionally does not
     * implement signing or retain payment secrets.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of CreateOrderRequest class.
     * 
     * @param order the order value to set.
     * @param sign the sign value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CreateOrderRequest(JsonObject order, String sign) {
        this.order = order;
        this.sign = sign;
    }

    /**
     * Get the openId property: The open_id property.
     * 
     * @return the openId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getOpenId() {
        return this.openId;
    }

    /**
     * Set the openId property: The open_id property.
     * 
     * @param openId the openId value to set.
     * @return the CreateOrderRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CreateOrderRequest setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    /**
     * Get the specialInfo property: The special_info property.
     * 
     * @return the specialInfo value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSpecialInfo() {
        return this.specialInfo;
    }

    /**
     * Set the specialInfo property: The special_info property.
     * 
     * @param specialInfo the specialInfo value to set.
     * @return the CreateOrderRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CreateOrderRequest setSpecialInfo(String specialInfo) {
        this.specialInfo = specialInfo;
        return this;
    }

    /**
     * Get the order property: The order property.
     * 
     * @return the order value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject getOrder() {
        return this.order;
    }

    /**
     * Get the sign property: The sign property.
     * 
     * @return the sign value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSign() {
        return this.sign;
    }

    /**
     * Get the additionalProperties property: Vendor-signed order creation payload. `sign` must come from an authorized
     * official client or payment integration; this SDK intentionally does not
     * implement signing or retain payment secrets.
     * 
     * @return the additionalProperties value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Map<String, BinaryData> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Vendor-signed order creation payload. `sign` must come from an authorized
     * official client or payment integration; this SDK intentionally does not
     * implement signing or retain payment secrets.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the CreateOrderRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CreateOrderRequest setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("order", this.order);
        jsonWriter.writeStringField("sign", this.sign);
        jsonWriter.writeStringField("open_id", this.openId);
        jsonWriter.writeStringField("special_info", this.specialInfo);
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
     * Reads an instance of CreateOrderRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CreateOrderRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CreateOrderRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static CreateOrderRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            JsonObject order = null;
            String sign = null;
            String openId = null;
            String specialInfo = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("order".equals(fieldName)) {
                    order = JsonObject.fromJson(reader);
                } else if ("sign".equals(fieldName)) {
                    sign = reader.getString();
                } else if ("open_id".equals(fieldName)) {
                    openId = reader.getString();
                } else if ("special_info".equals(fieldName)) {
                    specialInfo = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            CreateOrderRequest deserializedCreateOrderRequest = new CreateOrderRequest(order, sign);
            deserializedCreateOrderRequest.openId = openId;
            deserializedCreateOrderRequest.specialInfo = specialInfo;
            deserializedCreateOrderRequest.additionalProperties = additionalProperties;

            return deserializedCreateOrderRequest;
        });
    }
}
