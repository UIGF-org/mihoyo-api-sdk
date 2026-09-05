package uigf.launcher;

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
 * The GpuInfo model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class GpuInfo implements JsonSerializable<GpuInfo> {
    /*
     * The name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String name;

    /*
     * The vendor_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer vendorId;

    /*
     * The device_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer deviceId;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of GpuInfo class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GpuInfo() {
    }

    /**
     * Get the name property: The name property.
     * 
     * @return the name value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     * 
     * @param name the name value to set.
     * @return the GpuInfo object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GpuInfo setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the vendorId property: The vendor_id property.
     * 
     * @return the vendorId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getVendorId() {
        return this.vendorId;
    }

    /**
     * Set the vendorId property: The vendor_id property.
     * 
     * @param vendorId the vendorId value to set.
     * @return the GpuInfo object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GpuInfo setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
        return this;
    }

    /**
     * Get the deviceId property: The device_id property.
     * 
     * @return the deviceId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getDeviceId() {
        return this.deviceId;
    }

    /**
     * Set the deviceId property: The device_id property.
     * 
     * @param deviceId the deviceId value to set.
     * @return the GpuInfo object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GpuInfo setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
        return this;
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
     * Set the additionalProperties property: Additional properties.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the GpuInfo object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GpuInfo setAdditionalProperties(Map<String, BinaryData> additionalProperties) {
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
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeNumberField("vendor_id", this.vendorId);
        jsonWriter.writeNumberField("device_id", this.deviceId);
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
     * Reads an instance of GpuInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GpuInfo if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the GpuInfo.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GpuInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GpuInfo deserializedGpuInfo = new GpuInfo();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedGpuInfo.name = reader.getString();
                } else if ("vendor_id".equals(fieldName)) {
                    deserializedGpuInfo.vendorId = reader.getNullable(JsonReader::getInt);
                } else if ("device_id".equals(fieldName)) {
                    deserializedGpuInfo.deviceId = reader.getNullable(JsonReader::getInt);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedGpuInfo.additionalProperties = additionalProperties;

            return deserializedGpuInfo;
        });
    }
}
