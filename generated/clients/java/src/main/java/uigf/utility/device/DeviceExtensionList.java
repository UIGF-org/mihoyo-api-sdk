package uigf.utility.device;

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
 * The DeviceExtensionList model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class DeviceExtensionList implements JsonSerializable<DeviceExtensionList> {
    /*
     * The code property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer code;

    /*
     * The ext_list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private List<String> extList;

    /*
     * The msg property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String msg;

    /*
     * The pkg_list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private List<String> pkgList;

    /*
     * The pkg_str property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String pkgStr;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of DeviceExtensionList class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private DeviceExtensionList() {
    }

    /**
     * Get the code property: The code property.
     * 
     * @return the code value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getCode() {
        return this.code;
    }

    /**
     * Get the extList property: The ext_list property.
     * 
     * @return the extList value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<String> getExtList() {
        return this.extList;
    }

    /**
     * Get the msg property: The msg property.
     * 
     * @return the msg value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMsg() {
        return this.msg;
    }

    /**
     * Get the pkgList property: The pkg_list property.
     * 
     * @return the pkgList value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<String> getPkgList() {
        return this.pkgList;
    }

    /**
     * Get the pkgStr property: The pkg_str property.
     * 
     * @return the pkgStr value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getPkgStr() {
        return this.pkgStr;
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
        jsonWriter.writeNumberField("code", this.code);
        jsonWriter.writeArrayField("ext_list", this.extList, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("msg", this.msg);
        jsonWriter.writeArrayField("pkg_list", this.pkgList, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("pkg_str", this.pkgStr);
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
     * Reads an instance of DeviceExtensionList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeviceExtensionList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DeviceExtensionList.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static DeviceExtensionList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DeviceExtensionList deserializedDeviceExtensionList = new DeviceExtensionList();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("code".equals(fieldName)) {
                    deserializedDeviceExtensionList.code = reader.getNullable(JsonReader::getInt);
                } else if ("ext_list".equals(fieldName)) {
                    List<String> extList = reader.readArray(reader1 -> reader1.getString());
                    deserializedDeviceExtensionList.extList = extList;
                } else if ("msg".equals(fieldName)) {
                    deserializedDeviceExtensionList.msg = reader.getString();
                } else if ("pkg_list".equals(fieldName)) {
                    List<String> pkgList = reader.readArray(reader1 -> reader1.getString());
                    deserializedDeviceExtensionList.pkgList = pkgList;
                } else if ("pkg_str".equals(fieldName)) {
                    deserializedDeviceExtensionList.pkgStr = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedDeviceExtensionList.additionalProperties = additionalProperties;

            return deserializedDeviceExtensionList;
        });
    }
}
