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
 * The Announcement model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class Announcement implements JsonSerializable<Announcement> {
    /*
     * The ann_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Long annId;

    /*
     * The title property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String title;

    /*
     * The subtitle property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String subtitle;

    /*
     * The banner property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String banner;

    /*
     * The content property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String content;

    /*
     * The start_time property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String startTime;

    /*
     * The end_time property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String endTime;

    /*
     * The type property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer type;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of Announcement class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Announcement() {
    }

    /**
     * Get the annId property: The ann_id property.
     * 
     * @return the annId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Long getAnnId() {
        return this.annId;
    }

    /**
     * Get the title property: The title property.
     * 
     * @return the title value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getTitle() {
        return this.title;
    }

    /**
     * Get the subtitle property: The subtitle property.
     * 
     * @return the subtitle value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSubtitle() {
        return this.subtitle;
    }

    /**
     * Get the banner property: The banner property.
     * 
     * @return the banner value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getBanner() {
        return this.banner;
    }

    /**
     * Get the content property: The content property.
     * 
     * @return the content value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getContent() {
        return this.content;
    }

    /**
     * Get the startTime property: The start_time property.
     * 
     * @return the startTime value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getStartTime() {
        return this.startTime;
    }

    /**
     * Get the endTime property: The end_time property.
     * 
     * @return the endTime value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Get the type property: The type property.
     * 
     * @return the type value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getType() {
        return this.type;
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
        jsonWriter.writeNumberField("ann_id", this.annId);
        jsonWriter.writeStringField("title", this.title);
        jsonWriter.writeStringField("subtitle", this.subtitle);
        jsonWriter.writeStringField("banner", this.banner);
        jsonWriter.writeStringField("content", this.content);
        jsonWriter.writeStringField("start_time", this.startTime);
        jsonWriter.writeStringField("end_time", this.endTime);
        jsonWriter.writeNumberField("type", this.type);
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
     * Reads an instance of Announcement from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Announcement if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the Announcement.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static Announcement fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Announcement deserializedAnnouncement = new Announcement();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ann_id".equals(fieldName)) {
                    deserializedAnnouncement.annId = reader.getNullable(JsonReader::getLong);
                } else if ("title".equals(fieldName)) {
                    deserializedAnnouncement.title = reader.getString();
                } else if ("subtitle".equals(fieldName)) {
                    deserializedAnnouncement.subtitle = reader.getString();
                } else if ("banner".equals(fieldName)) {
                    deserializedAnnouncement.banner = reader.getString();
                } else if ("content".equals(fieldName)) {
                    deserializedAnnouncement.content = reader.getString();
                } else if ("start_time".equals(fieldName)) {
                    deserializedAnnouncement.startTime = reader.getString();
                } else if ("end_time".equals(fieldName)) {
                    deserializedAnnouncement.endTime = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedAnnouncement.type = reader.getNullable(JsonReader::getInt);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedAnnouncement.additionalProperties = additionalProperties;

            return deserializedAnnouncement;
        });
    }
}
