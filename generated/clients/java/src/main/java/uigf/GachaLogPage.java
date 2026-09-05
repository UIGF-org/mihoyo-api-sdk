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
import java.util.List;
import java.util.Map;

/**
 * The GachaLogPage model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GachaLogPage implements JsonSerializable<GachaLogPage> {
    /*
     * The page property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer page;

    /*
     * The size property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer size;

    /*
     * The total property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer total;

    /*
     * The region property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String region;

    /*
     * The list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<GachaItem> list;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of GachaLogPage class.
     * 
     * @param list the list value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private GachaLogPage(List<GachaItem> list) {
        this.list = list;
    }

    /**
     * Get the page property: The page property.
     * 
     * @return the page value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getPage() {
        return this.page;
    }

    /**
     * Get the size property: The size property.
     * 
     * @return the size value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getSize() {
        return this.size;
    }

    /**
     * Get the total property: The total property.
     * 
     * @return the total value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getTotal() {
        return this.total;
    }

    /**
     * Get the region property: The region property.
     * 
     * @return the region value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getRegion() {
        return this.region;
    }

    /**
     * Get the list property: The list property.
     * 
     * @return the list value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<GachaItem> getList() {
        return this.list;
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
        jsonWriter.writeArrayField("list", this.list, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeNumberField("page", this.page);
        jsonWriter.writeNumberField("size", this.size);
        jsonWriter.writeNumberField("total", this.total);
        jsonWriter.writeStringField("region", this.region);
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
     * Reads an instance of GachaLogPage from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GachaLogPage if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GachaLogPage.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GachaLogPage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            List<GachaItem> list = null;
            Integer page = null;
            Integer size = null;
            Integer total = null;
            String region = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("list".equals(fieldName)) {
                    list = reader.readArray(reader1 -> GachaItem.fromJson(reader1));
                } else if ("page".equals(fieldName)) {
                    page = reader.getNullable(JsonReader::getInt);
                } else if ("size".equals(fieldName)) {
                    size = reader.getNullable(JsonReader::getInt);
                } else if ("total".equals(fieldName)) {
                    total = reader.getNullable(JsonReader::getInt);
                } else if ("region".equals(fieldName)) {
                    region = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            GachaLogPage deserializedGachaLogPage = new GachaLogPage(list);
            deserializedGachaLogPage.page = page;
            deserializedGachaLogPage.size = size;
            deserializedGachaLogPage.total = total;
            deserializedGachaLogPage.region = region;
            deserializedGachaLogPage.additionalProperties = additionalProperties;

            return deserializedGachaLogPage;
        });
    }
}
