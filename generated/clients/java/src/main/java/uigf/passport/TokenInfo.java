package uigf.passport;

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
 * The TokenInfo model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class TokenInfo implements JsonSerializable<TokenInfo> {
    /*
     * The account_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Long accountId;

    /*
     * The uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String uid;

    /*
     * The token property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String token;

    /*
     * The game_token property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String gameToken;

    /*
     * The stoken property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String stoken;

    /*
     * The ltoken property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String ltoken;

    /*
     * The cookie_token property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String cookieToken;

    /*
     * The mid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String mid;

    /*
     * Additional properties
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of TokenInfo class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private TokenInfo() {
    }

    /**
     * Get the accountId property: The account_id property.
     * 
     * @return the accountId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Long getAccountId() {
        return this.accountId;
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
     * Get the token property: The token property.
     * 
     * @return the token value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getToken() {
        return this.token;
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
     * Get the stoken property: The stoken property.
     * 
     * @return the stoken value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getStoken() {
        return this.stoken;
    }

    /**
     * Get the ltoken property: The ltoken property.
     * 
     * @return the ltoken value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getLtoken() {
        return this.ltoken;
    }

    /**
     * Get the cookieToken property: The cookie_token property.
     * 
     * @return the cookieToken value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getCookieToken() {
        return this.cookieToken;
    }

    /**
     * Get the mid property: The mid property.
     * 
     * @return the mid value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getMid() {
        return this.mid;
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
        jsonWriter.writeNumberField("account_id", this.accountId);
        jsonWriter.writeStringField("uid", this.uid);
        jsonWriter.writeStringField("token", this.token);
        jsonWriter.writeStringField("game_token", this.gameToken);
        jsonWriter.writeStringField("stoken", this.stoken);
        jsonWriter.writeStringField("ltoken", this.ltoken);
        jsonWriter.writeStringField("cookie_token", this.cookieToken);
        jsonWriter.writeStringField("mid", this.mid);
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
     * Reads an instance of TokenInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TokenInfo if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the TokenInfo.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static TokenInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TokenInfo deserializedTokenInfo = new TokenInfo();
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("account_id".equals(fieldName)) {
                    deserializedTokenInfo.accountId = reader.getNullable(JsonReader::getLong);
                } else if ("uid".equals(fieldName)) {
                    deserializedTokenInfo.uid = reader.getString();
                } else if ("token".equals(fieldName)) {
                    deserializedTokenInfo.token = reader.getString();
                } else if ("game_token".equals(fieldName)) {
                    deserializedTokenInfo.gameToken = reader.getString();
                } else if ("stoken".equals(fieldName)) {
                    deserializedTokenInfo.stoken = reader.getString();
                } else if ("ltoken".equals(fieldName)) {
                    deserializedTokenInfo.ltoken = reader.getString();
                } else if ("cookie_token".equals(fieldName)) {
                    deserializedTokenInfo.cookieToken = reader.getString();
                } else if ("mid".equals(fieldName)) {
                    deserializedTokenInfo.mid = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            deserializedTokenInfo.additionalProperties = additionalProperties;

            return deserializedTokenInfo;
        });
    }
}
