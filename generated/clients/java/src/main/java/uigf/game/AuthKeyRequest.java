package uigf.game;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The AuthKeyRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class AuthKeyRequest implements JsonSerializable<AuthKeyRequest> {
    /*
     * The auth_appid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String authAppid;

    /*
     * The game_biz property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameBiz;

    /*
     * The game_uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameUid;

    /*
     * The region property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String region;

    /**
     * Creates an instance of AuthKeyRequest class.
     * 
     * @param authAppid the authAppid value to set.
     * @param gameBiz the gameBiz value to set.
     * @param gameUid the gameUid value to set.
     * @param region the region value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public AuthKeyRequest(String authAppid, String gameBiz, String gameUid, String region) {
        this.authAppid = authAppid;
        this.gameBiz = gameBiz;
        this.gameUid = gameUid;
        this.region = region;
    }

    /**
     * Get the authAppid property: The auth_appid property.
     * 
     * @return the authAppid value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getAuthAppid() {
        return this.authAppid;
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
     * Get the gameUid property: The game_uid property.
     * 
     * @return the gameUid value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameUid() {
        return this.gameUid;
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
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("auth_appid", this.authAppid);
        jsonWriter.writeStringField("game_biz", this.gameBiz);
        jsonWriter.writeStringField("game_uid", this.gameUid);
        jsonWriter.writeStringField("region", this.region);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AuthKeyRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AuthKeyRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AuthKeyRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static AuthKeyRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String authAppid = null;
            String gameBiz = null;
            String gameUid = null;
            String region = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("auth_appid".equals(fieldName)) {
                    authAppid = reader.getString();
                } else if ("game_biz".equals(fieldName)) {
                    gameBiz = reader.getString();
                } else if ("game_uid".equals(fieldName)) {
                    gameUid = reader.getString();
                } else if ("region".equals(fieldName)) {
                    region = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new AuthKeyRequest(authAppid, gameBiz, gameUid, region);
        });
    }
}
