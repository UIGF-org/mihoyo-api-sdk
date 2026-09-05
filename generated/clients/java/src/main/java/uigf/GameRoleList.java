package uigf;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The GameRoleList model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class GameRoleList implements JsonSerializable<GameRoleList> {
    /*
     * The list property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<GameRole> list;

    /**
     * Creates an instance of GameRoleList class.
     * 
     * @param list the list value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private GameRoleList(List<GameRole> list) {
        this.list = list;
    }

    /**
     * Get the list property: The list property.
     * 
     * @return the list value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<GameRole> getList() {
        return this.list;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("list", this.list, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GameRoleList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GameRoleList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GameRoleList.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static GameRoleList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            List<GameRole> list = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("list".equals(fieldName)) {
                    list = reader.readArray(reader1 -> GameRole.fromJson(reader1));
                } else {
                    reader.skipChildren();
                }
            }
            return new GameRoleList(list);
        });
    }
}
