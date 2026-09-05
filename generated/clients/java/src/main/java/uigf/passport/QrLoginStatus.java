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
import uigf.JsonObject;

/**
 * The QrLoginStatus model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class QrLoginStatus implements JsonSerializable<QrLoginStatus> {
    /*
     * The stat property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String stat;

    /*
     * The status property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String status;

    /*
     * The payload property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private JsonObject payload;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of QrLoginStatus class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private QrLoginStatus() {
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
     * Get the status property: The status property.
     * 
     * @return the status value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getStatus() {
        return this.status;
    }

    /**
     * Get the payload property: The payload property.
     * 
     * @return the payload value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject getPayload() {
        return this.payload;
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
        jsonWriter.writeStringField("stat", this.stat);
        jsonWriter.writeStringField("status", this.status);
        jsonWriter.writeJsonField("payload", this.payload);
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
     * Reads an instance of QrLoginStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of QrLoginStatus if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the QrLoginStatus.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static QrLoginStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            QrLoginStatus deserializedQrLoginStatus = new QrLoginStatus();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("stat".equals(fieldName)) {
                    deserializedQrLoginStatus.stat = reader.getString();
                } else if ("status".equals(fieldName)) {
                    deserializedQrLoginStatus.status = reader.getString();
                } else if ("payload".equals(fieldName)) {
                    deserializedQrLoginStatus.payload = JsonObject.fromJson(reader);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedQrLoginStatus.additionalProperties = additionalProperties;

            return deserializedQrLoginStatus;
        });
    }
}
