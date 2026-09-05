package uigf.passport;

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
 * The QrLoginTicket model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class QrLoginTicket implements JsonSerializable<QrLoginTicket> {
    /*
     * The ticket property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String ticket;

    /*
     * The url property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String url;

    /*
     * The expires_in property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer expiresIn;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of QrLoginTicket class.
     * 
     * @param ticket the ticket value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private QrLoginTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * Get the ticket property: The ticket property.
     * 
     * @return the ticket value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getTicket() {
        return this.ticket;
    }

    /**
     * Get the url property: The url property.
     * 
     * @return the url value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getUrl() {
        return this.url;
    }

    /**
     * Get the expiresIn property: The expires_in property.
     * 
     * @return the expiresIn value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getExpiresIn() {
        return this.expiresIn;
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
        jsonWriter.writeStringField("ticket", this.ticket);
        jsonWriter.writeStringField("url", this.url);
        jsonWriter.writeNumberField("expires_in", this.expiresIn);
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
     * Reads an instance of QrLoginTicket from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of QrLoginTicket if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the QrLoginTicket.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static QrLoginTicket fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String ticket = null;
            String url = null;
            Integer expiresIn = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ticket".equals(fieldName)) {
                    ticket = reader.getString();
                } else if ("url".equals(fieldName)) {
                    url = reader.getString();
                } else if ("expires_in".equals(fieldName)) {
                    expiresIn = reader.getNullable(JsonReader::getInt);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            QrLoginTicket deserializedQrLoginTicket = new QrLoginTicket(ticket);
            deserializedQrLoginTicket.url = url;
            deserializedQrLoginTicket.expiresIn = expiresIn;
            deserializedQrLoginTicket.additionalProperties = additionalProperties;

            return deserializedQrLoginTicket;
        });
    }
}
