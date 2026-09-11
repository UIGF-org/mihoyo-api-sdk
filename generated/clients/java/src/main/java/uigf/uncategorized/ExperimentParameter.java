package uigf.uncategorized;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;

/**
 * The ExperimentParameter model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ExperimentParameter implements JsonSerializable<ExperimentParameter> {
    /*
     * The k property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String k;

    /*
     * The v property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String v;

    /**
     * Creates an instance of ExperimentParameter class.
     * 
     * @param k the k value to set.
     * @param v the v value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ExperimentParameter(String k, String v) {
        this.k = k;
        this.v = v;
    }

    /**
     * Get the k property: The k property.
     * 
     * @return the k value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getK() {
        return this.k;
    }

    /**
     * Get the v property: The v property.
     * 
     * @return the v value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getV() {
        return this.v;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("k", this.k);
        jsonWriter.writeStringField("v", this.v);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExperimentParameter from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExperimentParameter if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ExperimentParameter.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ExperimentParameter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String k = null;
            String v = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("k".equals(fieldName)) {
                    k = reader.getString();
                } else if ("v".equals(fieldName)) {
                    v = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new ExperimentParameter(k, v);
        });
    }
}
