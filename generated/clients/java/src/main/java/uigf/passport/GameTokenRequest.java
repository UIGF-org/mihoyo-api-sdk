package uigf.passport;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The GameTokenRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GameTokenRequest implements JsonSerializable<GameTokenRequest> {
    /*
     * The account_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final long accountId;

    /*
     * The game_token property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String gameToken;

    /**
     * Creates an instance of GameTokenRequest class.
     * 
     * @param accountId the accountId value to set.
     * @param gameToken the gameToken value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GameTokenRequest(long accountId, String gameToken) {
        this.accountId = accountId;
        this.gameToken = gameToken;
    }

    /**
     * Get the accountId property: The account_id property.
     * 
     * @return the accountId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public long getAccountId() {
        return this.accountId;
    }

    /**
     * Get the gameToken property: The game_token property.
     * 
     * @return the gameToken value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGameToken() {
        return this.gameToken;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeLongField("account_id", this.accountId);
        jsonWriter.writeStringField("game_token", this.gameToken);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GameTokenRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GameTokenRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GameTokenRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GameTokenRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            long accountId = 0L;
            String gameToken = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("account_id".equals(fieldName)) {
                    accountId = reader.getLong();
                } else if ("game_token".equals(fieldName)) {
                    gameToken = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new GameTokenRequest(accountId, gameToken);
        });
    }
}
