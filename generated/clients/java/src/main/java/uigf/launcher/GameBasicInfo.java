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
import java.util.List;
import java.util.Map;
import uigf.JsonObject;

/**
 * The GameBasicInfo model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GameBasicInfo implements JsonSerializable<GameBasicInfo> {
    /*
     * The game_info_list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private List<JsonObject> gameInfoList;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of GameBasicInfo class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private GameBasicInfo() {
    }

    /**
     * Get the gameInfoList property: The game_info_list property.
     * 
     * @return the gameInfoList value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<JsonObject> getGameInfoList() {
        return this.gameInfoList;
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
        jsonWriter.writeArrayField("game_info_list", this.gameInfoList, (writer, element) -> writer.writeJson(element));
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
     * Reads an instance of GameBasicInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GameBasicInfo if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the GameBasicInfo.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GameBasicInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GameBasicInfo deserializedGameBasicInfo = new GameBasicInfo();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("game_info_list".equals(fieldName)) {
                    List<JsonObject> gameInfoList = reader.readArray(reader1 -> JsonObject.fromJson(reader1));
                    deserializedGameBasicInfo.gameInfoList = gameInfoList;
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedGameBasicInfo.additionalProperties = additionalProperties;

            return deserializedGameBasicInfo;
        });
    }
}
