package uigf.uncategorized;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.List;
import uigf.ApiResponseArray;
import uigf.JsonObject;

/**
 * The ExperimentListResponse model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ExperimentListResponse extends ApiResponseArray {
    /*
     * The success property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Boolean success;

    /**
     * Creates an instance of ExperimentListResponse class.
     * 
     * @param retcode the retcode value to set.
     * @param message the message value to set.
     * @param data the data value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private ExperimentListResponse(int retcode, String message, List<JsonObject> data) {
        super(retcode, message, data);
    }

    /**
     * Get the success property: The success property.
     * 
     * @return the success value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public Boolean isSuccess() {
        return this.success;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("retcode", getRetcode());
        jsonWriter.writeStringField("message", getMessage());
        jsonWriter.writeArrayField("data", getData(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeBooleanField("success", this.success);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExperimentListResponse from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExperimentListResponse if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ExperimentListResponse.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ExperimentListResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            int retcode = 0;
            String message = null;
            List<JsonObject> data = null;
            Boolean success = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("retcode".equals(fieldName)) {
                    retcode = reader.getInt();
                } else if ("message".equals(fieldName)) {
                    message = reader.getString();
                } else if ("data".equals(fieldName)) {
                    data = reader.readArray(reader1 -> JsonObject.fromJson(reader1));
                } else if ("success".equals(fieldName)) {
                    success = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }
            ExperimentListResponse deserializedExperimentListResponse
                = new ExperimentListResponse(retcode, message, data);
            deserializedExperimentListResponse.success = success;

            return deserializedExperimentListResponse;
        });
    }
}
