package com.pk.rentflat.converter.attributeconverter;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class ListToStringConverter implements AttributeConverter<List<byte[]>, String> {

    @Override
    public String convertToDatabaseColumn(List<byte[]> attribute) {
        if (!attribute.isEmpty()) {
            List<String> attributes = attribute
                    .stream()
                    .map(s -> Base64.getEncoder().encodeToString(s))
                    .toList();
            return String.join(",", attributes);
        }

        return null;
    }

    @Override
    public List<byte[]> convertToEntityAttribute(String dbData) {
        if(dbData.isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays
                .stream(dbData.split(","))
                .map(s -> Base64.getDecoder().decode(s))
                .toList();
    }
}