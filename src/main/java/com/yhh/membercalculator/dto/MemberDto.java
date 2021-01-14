package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.model.WorkTime;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long memberId;

    @NotNull
    private String name;

    private int totalWage;

    private List<WorkTimeDto> workTimes = new ArrayList<>();

    public MemberDto(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public Member toEntity() {
        return new Member(name);
    }

    public void addWorkTimeDto(WorkTimeDto workTimeDto) {
        this.workTimes.add(workTimeDto);
    }

    public int calcTotalWage() {
        totalWage = 0;
        for (WorkTimeDto workTimeDto : workTimes) {
            totalWage += workTimeDto.getWeekWage();
        }
        return totalWage;
    }
}
