package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model.deserializer;

import com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model.BaseModel;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Dynamic Identifier List Deserializer
public class DynamicIdentifierListDeserializer<T extends BaseModel> implements JsonDeserializer<List<T>> {

    private Class<T> genericType;

    public DynamicIdentifierListDeserializer(Class<T> genericType) {
        this.genericType = genericType;
    }

    @Override
    public List<T> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        // List
        List<T> list = new ArrayList<T>();

        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            T item = context.<T>deserialize(entry.getValue(), genericType);
            item.id(entry.getKey());
            list.add(item);
        }

        // return
        return list;
    }
}