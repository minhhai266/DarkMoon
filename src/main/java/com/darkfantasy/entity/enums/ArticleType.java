package com.darkfantasy.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ArticleType {
    IMPORTANT(1, "Quan trọng"),
    UPDATE(2, "Cập nhật"),
    NEWS(3, "Tin tức"),
    EVENT(4, "Sự kiện");

    public final int value;
    private final String displayName;

    public static ArticleType fromValue(int value) {
        for (ArticleType type : ArticleType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy loại bài viết: " + value);
    }
}
