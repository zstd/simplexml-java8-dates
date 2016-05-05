package com.example.simplexml;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {

   public LocalDateTime read(InputNode node) throws Exception {
      String name = node.getValue();


      return LocalDateTime.parse(name, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
   }

   public void write(OutputNode node, LocalDateTime input) {
      String value = input.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

      node.setValue(value);
   }
}