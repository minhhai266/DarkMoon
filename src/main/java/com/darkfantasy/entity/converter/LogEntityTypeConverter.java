package com.darkfantasy.entity.converter;

import com.darkfantasy.entity.enums.LogEntityType;

import jakarta.persistence.AttributeConverter;

public class LogEntityTypeConverter implements AttributeConverter<LogEntityType, Long>{

    @Override
    public Long convertToDatabaseColumn(LogEntityType attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public LogEntityType convertToEntityAttribute(Long dbData) {
        return dbData == null ? null : LogEntityType.fromValue(dbData);
    }

}
