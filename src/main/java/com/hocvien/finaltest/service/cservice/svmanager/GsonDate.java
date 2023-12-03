package com.hocvien.finaltest.service.cservice.svmanager;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class GsonDate {
    public static Gson gsonDate;

    public GsonDate() {
    }

    static {
        gsonDate = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                }
        ).create();
    }
}
