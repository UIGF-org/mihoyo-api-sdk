package uigf.game.genshin.dispatch;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The SignedDispatchResponse model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class SignedDispatchResponse implements JsonSerializable<SignedDispatchResponse> {
    /*
     * The content property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String content;

    /*
     * The sign property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String sign;

    /**
     * Creates an instance of SignedDispatchResponse class.
     * 
     * @param content the content value to set.
     * @param sign the sign value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private SignedDispatchResponse(String content, String sign) {
        this.content = content;
        this.sign = sign;
    }

    /**
     * Get the content property: The content property.
     * 
     * @return the content value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getContent() {
        return this.content;
    }

    /**
     * Get the sign property: The sign property.
     * 
     * @return the sign value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSign() {
        return this.sign;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("content", this.content);
        jsonWriter.writeStringField("sign", this.sign);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SignedDispatchResponse from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SignedDispatchResponse if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SignedDispatchResponse.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static SignedDispatchResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String content = null;
            String sign = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("content".equals(fieldName)) {
                    content = reader.getString();
                } else if ("sign".equals(fieldName)) {
                    sign = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new SignedDispatchResponse(content, sign);
        });
    }
}
