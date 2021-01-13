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
public class MemberDto {

    private Long id;

    private String name;

    private TimeDto workWages;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.workWages = new TimeDto(member.getWorkTimes());
    }
}
