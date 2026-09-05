package uigf.game;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The CharacterDetailRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class CharacterDetailRequest extends CharacterListRequest {
    /*
     * The character_ids property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<String> characterIds;

    /**
     * Creates an instance of CharacterDetailRequest class.
     * 
     * @param roleId the roleId value to set.
     * @param server the server value to set.
     * @param characterIds the characterIds value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CharacterDetailRequest(String roleId, String server, List<String> characterIds) {
        super(roleId, server);
        this.characterIds = characterIds;
    }

    /**
     * Get the characterIds property: The character_ids property.
     * 
     * @return the characterIds value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<String> getCharacterIds() {
        return this.characterIds;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("role_id", getRoleId());
        jsonWriter.writeStringField("server", getServer());
        jsonWriter.writeArrayField("character_ids", this.characterIds,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CharacterDetailRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CharacterDetailRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CharacterDetailRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static CharacterDetailRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String roleId = null;
            String server = null;
            List<String> characterIds = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("role_id".equals(fieldName)) {
                    roleId = reader.getString();
                } else if ("server".equals(fieldName)) {
                    server = reader.getString();
                } else if ("character_ids".equals(fieldName)) {
                    characterIds = reader.readArray(reader1 -> reader1.getString());
                } else {
                    reader.skipChildren();
                }
            }
            return new CharacterDetailRequest(roleId, server, characterIds);
        });
    }
}
