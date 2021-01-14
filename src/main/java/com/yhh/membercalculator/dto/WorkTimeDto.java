package com.yhh.membercalculator.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
@Builder
public class WorkTimeDto {
    private int week;

    private int workTime;

    private boolean isVacationPay;

    private int weekWage;
}
