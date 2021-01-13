package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.Member;
import java.util.ArrayList;
import java.util.List;
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

    private int totalWage;

    private List<WorkTimeDto> workTimeDtos = new ArrayList<>();

    public MemberDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addWorkTimeDto(WorkTimeDto workTimeDto) {
        workTimeDtos.add(workTimeDto);
    }

    public Member toEntity() {
        return new Member(name);
    }

    public int calcTotalWage() {
        totalWage = 0;
        for (WorkTimeDto workTimeDto : workTimeDtos) {
            totalWage += workTimeDto.getWeekWage();
        }
        return totalWage;
    }
}
