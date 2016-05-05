package com.example.simplexml;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeConverterTest {

    private StringWriter writer = new StringWriter();
    private Entity entity = new Entity(LocalDateTime.parse("2007-12-03T10:15:30"));

    private String serialized =
            "<entity>\n" +
            "   <TIMESTAMP>2007-12-03T10:15:30</TIMESTAMP>\n" +
            "</entity>";

    @Test
    public void writeSucceed() throws Exception {
        Serializer serializer = createSerializer();
        serializer.write(entity, writer);

        assertEquals(serialized, writer.toString());
    }

    private Serializer createSerializer() {
        Strategy strategy = new AnnotationStrategy();
        return new Persister(strategy);
    }


    @Test
    public void readSucceed() throws Exception {
        Serializer serializer = createSerializer();

        Entity serializedEntity = serializer.read(Entity.class, new StringReader(serialized));

        assertEquals(entity, serializedEntity);
    }
}