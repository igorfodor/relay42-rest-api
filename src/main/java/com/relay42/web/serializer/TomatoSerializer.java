package com.relay42.web.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.relay42.core.tomato.domain.Tomato;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class TomatoSerializer extends JsonSerializer<Tomato> {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    @Override
    public void serialize(Tomato tomato, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("uddi", tomato.getUUID());
        jsonGenerator.writeNumberField("tomatoes", tomato.getTomatoes());
        jsonGenerator.writeStringField("provider", tomato.getProvider().getName());

        jsonGenerator.writeStringField("timestamp", tomato.getTimestamp().format(dateTimeFormatter));
        jsonGenerator.writeEndObject();
    }

}
