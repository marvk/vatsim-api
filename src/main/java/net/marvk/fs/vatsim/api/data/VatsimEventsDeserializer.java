package net.marvk.fs.vatsim.api.data;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VatsimEventsDeserializer implements JsonDeserializer<VatsimEvents> {
    @Override
    public VatsimEvents deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context) throws JsonParseException {
        final JsonArray data = json.getAsJsonObject().get("data").getAsJsonArray();

        final List<VatsimEvent> result = StreamSupport
                .stream(data.spliterator(), false)
                .map(e -> (VatsimEvent) context.deserialize(e, VatsimEvent.class))
                .collect(Collectors.toList());

        return new VatsimEvents(result);
    }
}
