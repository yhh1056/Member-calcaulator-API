package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.Member;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long id;

    @NotNull
    private String name;

    private TimeDto workWages;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.workWages = new TimeDto(member.getWorkTimes());
    }

    public Member toEntity(String name) {
        return new Member(name);
    }
}
