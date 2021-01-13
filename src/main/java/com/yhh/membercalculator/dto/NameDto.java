package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.Member;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
@Setter
public class NameDto {
    private String name;

    public Member toEntity() {
        return new Member(name);
    }
}
