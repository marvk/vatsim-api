package net.marvk.fs.vatsim.api.deserialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context) throws JsonParseException {
        if ("0001-01-01T00:00:00".equals(json.getAsString())) {
            return null;
        }

        try {
            return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime();
        } catch (final DateTimeParseException e) {
            return null;
        }
    }
}
