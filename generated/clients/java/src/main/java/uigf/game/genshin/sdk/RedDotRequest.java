package uigf.game.genshin.sdk;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The RedDotRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class RedDotRequest implements JsonSerializable<RedDotRequest> {
    /*
     * The game_biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameBiz;

    /*
     * The player_level property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final int playerLevel;

    /*
     * The region property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String region;

    /*
     * The uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String uid;

    /**
     * Creates an instance of RedDotRequest class.
     * 
     * @param gameBiz the gameBiz value to set.
     * @param playerLevel the playerLevel value to set.
     * @param region the region value to set.
     * @param uid the uid value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public RedDotRequest(String gameBiz, int playerLevel, String region, String uid) {
        this.gameBiz = gameBiz;
        this.playerLevel = playerLevel;
        this.region = region;
        this.uid = uid;
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
     * Get the playerLevel property: The player_level property.
     * 
     * @return the playerLevel value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public int getPlayerLevel() {
        return this.playerLevel;
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
     * Get the uid property: The uid property.
     * 
     * @return the uid value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getUid() {
        return this.uid;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("game_biz", this.gameBiz);
        jsonWriter.writeIntField("player_level", this.playerLevel);
        jsonWriter.writeStringField("region", this.region);
        jsonWriter.writeStringField("uid", this.uid);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RedDotRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RedDotRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RedDotRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static RedDotRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String gameBiz = null;
            int playerLevel = 0;
            String region = null;
            String uid = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("game_biz".equals(fieldName)) {
                    gameBiz = reader.getString();
                } else if ("player_level".equals(fieldName)) {
                    playerLevel = reader.getInt();
                } else if ("region".equals(fieldName)) {
                    region = reader.getString();
                } else if ("uid".equals(fieldName)) {
                    uid = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new RedDotRequest(gameBiz, playerLevel, region, uid);
        });
    }
}
