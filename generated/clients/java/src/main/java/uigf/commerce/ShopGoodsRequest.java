package uigf.commerce;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The ShopGoodsRequest model.
 */
@Metadata(properties = { MetadataProperties.FLUENT })
public final class ShopGoodsRequest implements JsonSerializable<ShopGoodsRequest> {
    /*
     * The released_flag property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Boolean releasedFlag;

    /*
     * The game property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String game;

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

    /*
     * The account property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String account;

    /**
     * Creates an instance of ShopGoodsRequest class.
     * 
     * @param game the game value to set.
     * @param region the region value to set.
     * @param uid the uid value to set.
     * @param account the account value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ShopGoodsRequest(String game, String region, String uid, String account) {
        this.game = game;
        this.region = region;
        this.uid = uid;
        this.account = account;
    }

    /**
     * Get the releasedFlag property: The released_flag property.
     * 
     * @return the releasedFlag value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Boolean isReleasedFlag() {
        return this.releasedFlag;
    }

    /**
     * Set the releasedFlag property: The released_flag property.
     * 
     * @param releasedFlag the releasedFlag value to set.
     * @return the ShopGoodsRequest object itself.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ShopGoodsRequest setReleasedFlag(Boolean releasedFlag) {
        this.releasedFlag = releasedFlag;
        return this;
    }

    /**
     * Get the game property: The game property.
     * 
     * @return the game value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getGame() {
        return this.game;
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
     * Get the account property: The account property.
     * 
     * @return the account value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getAccount() {
        return this.account;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("game", this.game);
        jsonWriter.writeStringField("region", this.region);
        jsonWriter.writeStringField("uid", this.uid);
        jsonWriter.writeStringField("account", this.account);
        jsonWriter.writeBooleanField("released_flag", this.releasedFlag);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ShopGoodsRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ShopGoodsRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ShopGoodsRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ShopGoodsRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String game = null;
            String region = null;
            String uid = null;
            String account = null;
            Boolean releasedFlag = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("game".equals(fieldName)) {
                    game = reader.getString();
                } else if ("region".equals(fieldName)) {
                    region = reader.getString();
                } else if ("uid".equals(fieldName)) {
                    uid = reader.getString();
                } else if ("account".equals(fieldName)) {
                    account = reader.getString();
                } else if ("released_flag".equals(fieldName)) {
                    releasedFlag = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }
            ShopGoodsRequest deserializedShopGoodsRequest = new ShopGoodsRequest(game, region, uid, account);
            deserializedShopGoodsRequest.releasedFlag = releasedFlag;

            return deserializedShopGoodsRequest;
        });
    }
}
