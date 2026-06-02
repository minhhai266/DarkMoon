package com.darkfantasy.entity.converter;

import com.darkfantasy.entity.enums.ArticleType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ArticleTypeConverter implements AttributeConverter<ArticleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ArticleType type) {
        return type == null ? null : type.getValue();
    }

    @Override
    public ArticleType convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : ArticleType.fromValue(dbData);
    }

}
