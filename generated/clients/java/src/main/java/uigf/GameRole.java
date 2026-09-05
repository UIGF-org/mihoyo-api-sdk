package uigf;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * Standard game account identity reused by record APIs.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GameRole implements JsonSerializable<GameRole> {
    /*
     * The game_biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameBiz;

    /*
     * The region property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String region;

    /*
     * The game_uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameUid;

    /*
     * The nickname property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String nickname;

    /*
     * The level property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer level;

    /*
     * The is_chosen property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Boolean isChosen;

    /*
     * The region_name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String regionName;

    /*
     * The game_name property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String gameName;

    /**
     * Creates an instance of GameRole class.
     * 
     * @param gameBiz the gameBiz value to set.
     * @param region the region value to set.
     * @param gameUid the gameUid value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private GameRole(String gameBiz, String region, String gameUid) {
        this.gameBiz = gameBiz;
        this.region = region;
        this.gameUid = gameUid;
    }

    /**
     * Get the gameBiz property: The game_biz property.
     * 
     * @return the gameBiz value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameBiz() {
        return this.gameBiz;
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
     * Get the gameUid property: The game_uid property.
     * 
     * @return the gameUid value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameUid() {
        return this.gameUid;
    }

    /**
     * Get the nickname property: The nickname property.
     * 
     * @return the nickname value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Get the level property: The level property.
     * 
     * @return the level value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getLevel() {
        return this.level;
    }

    /**
     * Get the isChosen property: The is_chosen property.
     * 
     * @return the isChosen value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Boolean isChosen() {
        return this.isChosen;
    }

    /**
     * Get the regionName property: The region_name property.
     * 
     * @return the regionName value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getRegionName() {
        return this.regionName;
    }

    /**
     * Get the gameName property: The game_name property.
     * 
     * @return the gameName value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameName() {
        return this.gameName;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("game_biz", this.gameBiz);
        jsonWriter.writeStringField("region", this.region);
        jsonWriter.writeStringField("game_uid", this.gameUid);
        jsonWriter.writeStringField("nickname", this.nickname);
        jsonWriter.writeNumberField("level", this.level);
        jsonWriter.writeBooleanField("is_chosen", this.isChosen);
        jsonWriter.writeStringField("region_name", this.regionName);
        jsonWriter.writeStringField("game_name", this.gameName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GameRole from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GameRole if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GameRole.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GameRole fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String gameBiz = null;
            String region = null;
            String gameUid = null;
            String nickname = null;
            Integer level = null;
            Boolean isChosen = null;
            String regionName = null;
            String gameName = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("game_biz".equals(fieldName)) {
                    gameBiz = reader.getString();
                } else if ("region".equals(fieldName)) {
                    region = reader.getString();
                } else if ("game_uid".equals(fieldName)) {
                    gameUid = reader.getString();
                } else if ("nickname".equals(fieldName)) {
                    nickname = reader.getString();
                } else if ("level".equals(fieldName)) {
                    level = reader.getNullable(JsonReader::getInt);
                } else if ("is_chosen".equals(fieldName)) {
                    isChosen = reader.getNullable(JsonReader::getBoolean);
                } else if ("region_name".equals(fieldName)) {
                    regionName = reader.getString();
                } else if ("game_name".equals(fieldName)) {
                    gameName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            GameRole deserializedGameRole = new GameRole(gameBiz, region, gameUid);
            deserializedGameRole.nickname = nickname;
            deserializedGameRole.level = level;
            deserializedGameRole.isChosen = isChosen;
            deserializedGameRole.regionName = regionName;
            deserializedGameRole.gameName = gameName;

            return deserializedGameRole;
        });
    }
}
