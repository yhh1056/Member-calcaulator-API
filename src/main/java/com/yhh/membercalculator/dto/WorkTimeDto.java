package com.yhh.membercalculator.dto;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkTimeDto {
    private int week;

    private int workTime;

    private boolean isVacationPay;

    private int weekWage;
}
