package com.example.simplexml;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.convert.Convert;

import java.time.LocalDateTime;
import java.util.Objects;

public class Entity {

    @Element(name = "TIMESTAMP")
    @Convert(LocalDateTimeConverter.class)
    private LocalDateTime date;

    public Entity() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Entity(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
