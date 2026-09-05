package uigf;

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
 * A user profile returned by community-account APIs.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class CommunityUser implements JsonSerializable<CommunityUser> {
    /*
     * The uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String uid;

    /*
     * The nickname property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String nickname;

    /*
     * The introduce property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String introduce;

    /*
     * The avatar_url property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String avatarUrl;

    /*
     * The gender property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Integer gender;

    /*
     * The level_exp property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private JsonObject levelExp;

    /*
     * The community_info property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private JsonObject communityInfo;

    /*
     * A user profile returned by community-account APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Map<String, BinaryData> additionalProperties;

    /**
     * Creates an instance of CommunityUser class.
     * 
     * @param uid the uid value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private CommunityUser(String uid) {
        this.uid = uid;
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
     * Get the nickname property: The nickname property.
     * 
     * @return the nickname value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Get the introduce property: The introduce property.
     * 
     * @return the introduce value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getIntroduce() {
        return this.introduce;
    }

    /**
     * Get the avatarUrl property: The avatar_url property.
     * 
     * @return the avatarUrl value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    /**
     * Get the gender property: The gender property.
     * 
     * @return the gender value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Integer getGender() {
        return this.gender;
    }

    /**
     * Get the levelExp property: The level_exp property.
     * 
     * @return the levelExp value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject getLevelExp() {
        return this.levelExp;
    }

    /**
     * Get the communityInfo property: The community_info property.
     * 
     * @return the communityInfo value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public JsonObject getCommunityInfo() {
        return this.communityInfo;
    }

    /**
     * Get the additionalProperties property: A user profile returned by community-account APIs.
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
        jsonWriter.writeStringField("uid", this.uid);
        jsonWriter.writeStringField("nickname", this.nickname);
        jsonWriter.writeStringField("introduce", this.introduce);
        jsonWriter.writeStringField("avatar_url", this.avatarUrl);
        jsonWriter.writeNumberField("gender", this.gender);
        jsonWriter.writeJsonField("level_exp", this.levelExp);
        jsonWriter.writeJsonField("community_info", this.communityInfo);
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
     * Reads an instance of CommunityUser from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CommunityUser if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CommunityUser.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static CommunityUser fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String uid = null;
            String nickname = null;
            String introduce = null;
            String avatarUrl = null;
            Integer gender = null;
            JsonObject levelExp = null;
            JsonObject communityInfo = null;
            Map<String, BinaryData> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("uid".equals(fieldName)) {
                    uid = reader.getString();
                } else if ("nickname".equals(fieldName)) {
                    nickname = reader.getString();
                } else if ("introduce".equals(fieldName)) {
                    introduce = reader.getString();
                } else if ("avatar_url".equals(fieldName)) {
                    avatarUrl = reader.getString();
                } else if ("gender".equals(fieldName)) {
                    gender = reader.getNullable(JsonReader::getInt);
                } else if ("level_exp".equals(fieldName)) {
                    levelExp = JsonObject.fromJson(reader);
                } else if ("community_info".equals(fieldName)) {
                    communityInfo = JsonObject.fromJson(reader);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName,
                        reader.getNullable(nonNullReader -> BinaryData.fromObject(nonNullReader.readUntyped())));
                }
            }
            CommunityUser deserializedCommunityUser = new CommunityUser(uid);
            deserializedCommunityUser.nickname = nickname;
            deserializedCommunityUser.introduce = introduce;
            deserializedCommunityUser.avatarUrl = avatarUrl;
            deserializedCommunityUser.gender = gender;
            deserializedCommunityUser.levelExp = levelExp;
            deserializedCommunityUser.communityInfo = communityInfo;
            deserializedCommunityUser.additionalProperties = additionalProperties;

            return deserializedCommunityUser;
        });
    }
}
