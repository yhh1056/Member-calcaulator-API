package com.yhh.membercalculator.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
@Setter
public class WorkTimeDto {

    @Max(5)
    @Min(0)
    @NotNull
    private int weekNumber;

    @NotNull
    private int workTime;

    @NotNull
    private boolean isVacationPay;

    @NotNull
    private int weekWage;
}
