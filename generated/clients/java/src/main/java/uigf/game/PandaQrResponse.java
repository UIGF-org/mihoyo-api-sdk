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
 * The PandaQrResponse model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class PandaQrResponse implements JsonSerializable<PandaQrResponse> {
    /*
     * The ticket property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String ticket;

    /*
     * The url property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String url;

    /*
     * The stat property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String stat;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of PandaQrResponse class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private PandaQrResponse() {
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
     * Get the stat property: The stat property.
     * 
     * @return the stat value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getStat() {
        return this.stat;
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
        jsonWriter.writeStringField("stat", this.stat);
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
     * Reads an instance of PandaQrResponse from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PandaQrResponse if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the PandaQrResponse.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static PandaQrResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PandaQrResponse deserializedPandaQrResponse = new PandaQrResponse();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ticket".equals(fieldName)) {
                    deserializedPandaQrResponse.ticket = reader.getString();
                } else if ("url".equals(fieldName)) {
                    deserializedPandaQrResponse.url = reader.getString();
                } else if ("stat".equals(fieldName)) {
                    deserializedPandaQrResponse.stat = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedPandaQrResponse.additionalProperties = additionalProperties;

            return deserializedPandaQrResponse;
        });
    }
}
