package uigf.uncategorized;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The ExperimentListRequest model.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class ExperimentListRequest implements JsonSerializable<ExperimentListRequest> {
    /*
     * The app_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final int appId;

    /*
     * The app_sign property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String appSign;

    /*
     * The params property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<ExperimentParameter> params;

    /*
     * The scene_id property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String sceneId;

    /*
     * The uid property.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final String uid;

    /**
     * Creates an instance of ExperimentListRequest class.
     * 
     * @param appId the appId value to set.
     * @param appSign the appSign value to set.
     * @param params the params value to set.
     * @param sceneId the sceneId value to set.
     * @param uid the uid value to set.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ExperimentListRequest(int appId, String appSign, List<ExperimentParameter> params, String sceneId,
        String uid) {
        this.appId = appId;
        this.appSign = appSign;
        this.params = params;
        this.sceneId = sceneId;
        this.uid = uid;
    }

    /**
     * Get the appId property: The app_id property.
     * 
     * @return the appId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public int getAppId() {
        return this.appId;
    }

    /**
     * Get the appSign property: The app_sign property.
     * 
     * @return the appSign value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getAppSign() {
        return this.appSign;
    }

    /**
     * Get the params property: The params property.
     * 
     * @return the params value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<ExperimentParameter> getParams() {
        return this.params;
    }

    /**
     * Get the sceneId property: The scene_id property.
     * 
     * @return the sceneId value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getSceneId() {
        return this.sceneId;
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
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("app_id", this.appId);
        jsonWriter.writeStringField("app_sign", this.appSign);
        jsonWriter.writeArrayField("params", this.params, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("scene_id", this.sceneId);
        jsonWriter.writeStringField("uid", this.uid);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExperimentListRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExperimentListRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ExperimentListRequest.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static ExperimentListRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            int appId = 0;
            String appSign = null;
            List<ExperimentParameter> params = null;
            String sceneId = null;
            String uid = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("app_id".equals(fieldName)) {
                    appId = reader.getInt();
                } else if ("app_sign".equals(fieldName)) {
                    appSign = reader.getString();
                } else if ("params".equals(fieldName)) {
                    params = reader.readArray(reader1 -> ExperimentParameter.fromJson(reader1));
                } else if ("scene_id".equals(fieldName)) {
                    sceneId = reader.getString();
                } else if ("uid".equals(fieldName)) {
                    uid = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return new ExperimentListRequest(appId, appSign, params, sceneId, uid);
        });
    }
}
