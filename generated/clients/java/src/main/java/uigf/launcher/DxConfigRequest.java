package uigf.launcher;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The DxConfigRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class DxConfigRequest implements JsonSerializable<DxConfigRequest> {
    /*
     * The launcher_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String launcherId;

    /*
     * The language property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String language;

    /*
     * The game_ids property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<String> gameIds;

    /*
     * The gpu_info property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<GpuInfo> gpuInfo;

    /**
     * Creates an instance of DxConfigRequest class.
     * 
     * @param launcherId the launcherId value to set.
     * @param language the language value to set.
     * @param gameIds the gameIds value to set.
     * @param gpuInfo the gpuInfo value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public DxConfigRequest(String launcherId, String language, List<String> gameIds, List<GpuInfo> gpuInfo) {
        this.launcherId = launcherId;
        this.language = language;
        this.gameIds = gameIds;
        this.gpuInfo = gpuInfo;
    }

    /**
     * Get the launcherId property: The launcher_id property.
     * 
     * @return the launcherId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getLauncherId() {
        return this.launcherId;
    }

    /**
     * Get the language property: The language property.
     * 
     * @return the language value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getLanguage() {
        return this.language;
    }

    /**
     * Get the gameIds property: The game_ids property.
     * 
     * @return the gameIds value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<String> getGameIds() {
        return this.gameIds;
    }

    /**
     * Get the gpuInfo property: The gpu_info property.
     * 
     * @return the gpuInfo value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<GpuInfo> getGpuInfo() {
        return this.gpuInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("launcher_id", this.launcherId);
        jsonWriter.writeStringField("language", this.language);
        jsonWriter.writeArrayField("game_ids", this.gameIds, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("gpu_info", this.gpuInfo, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DxConfigRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DxConfigRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DxConfigRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static DxConfigRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String launcherId = null;
            String language = null;
            List<String> gameIds = null;
            List<GpuInfo> gpuInfo = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("launcher_id".equals(fieldName)) {
                    launcherId = reader.getString();
                } else if ("language".equals(fieldName)) {
                    language = reader.getString();
                } else if ("game_ids".equals(fieldName)) {
                    gameIds = reader.readArray(reader1 -> reader1.getString());
                } else if ("gpu_info".equals(fieldName)) {
                    gpuInfo = reader.readArray(reader1 -> GpuInfo.fromJson(reader1));
                } else {
                    reader.skipChildren();
                }
            }
            return new DxConfigRequest(launcherId, language, gameIds, gpuInfo);
        });
    }
}
