package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.Member;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
@Setter
public class MemberDto {
    private Long memberId;

    @NotNull
    private String name;

    private List<WorkTimeDto> workTimes = new ArrayList<>();

    private int totalWage;

    public Member toEntity() {
        return new Member(name);
    }
}
