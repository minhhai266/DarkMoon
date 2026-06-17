package com.darkfantasy.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogEntityType {
    ARTICLE(1),
    STORY(2),
    WORLD(3),
    CHARACTER(4),
    FAQ(5),
    USER(6),
    CONTACT(7),
    CONTRIBUTOR(8);

    private final long code;
        public static LogEntityType fromValue(long code) {
        for (LogEntityType action : LogEntityType.values()) {
            if (action.code == code) {
                return action;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy loại Entity: " + code);
    }
}
