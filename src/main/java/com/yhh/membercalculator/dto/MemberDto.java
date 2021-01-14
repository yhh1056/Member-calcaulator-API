package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.Member;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
@Builder
public class MemberDto {
    private Long memberId;

    @NotNull
    private String name;

    private List<WorkTimeDto> workTimes;

    private int totalWage;

    public Member toEntity() {
        return new Member(name);
    }

    public void addWorkTimeDto(WorkTimeDto workTimeDto) {
        this.workTimes.add(workTimeDto);
    }
}
