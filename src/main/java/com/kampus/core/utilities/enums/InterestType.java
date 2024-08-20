package com.kampus.core.utilities.enums;

import lombok.Getter;

import static com.kampus.core.constants.InterestConstant.*;

@Getter
public enum InterestType {
    SPORTS(INTEREST_CONSTANT_NAME_SPORT, INTEREST_CONSTANT_TYPE_PHYSICAL_ACTIVITY),
    MUSIC(INTEREST_CONSTANT_NAME_MUSIC, INTEREST_CONSTANT_TYPE_ARTISTIC_EXPRESSION),
    TECHNOLOGY(INTEREST_CONSTANT_NAME_TECHNOLOGY, INTEREST_CONSTANT_TYPE_INNOVATIVE_THINKING);

    private final String name;
    private final String type;

    InterestType(String name, String type) {
        this.name = name;
        this.type = type;
    }

}

