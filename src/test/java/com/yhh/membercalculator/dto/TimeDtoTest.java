package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.WorkTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2021/01/13
 */
class TimeDtoTest {

    @Test
    @DisplayName("시급이 계산되어 나오는지")
    void calculate() {
        List<WorkTime> workTimes = List.of(
            new WorkTime(10, false),
            new WorkTime(10, false),
            new WorkTime(10, false));

        TimeDto timeDto = new TimeDto(workTimes);

        Assertions.assertEquals(261600, timeDto.getTotalWage());
    }

    @Test
    @DisplayName("주휴수당이 계산되어 나오는지")
    void calculateOption() {
        List<WorkTime> workTimes = List.of(
            new WorkTime(15, true),
            new WorkTime(15, true),
            new WorkTime(15, true));

        TimeDto timeDto = new TimeDto(workTimes);

        Assertions.assertEquals(470880, timeDto.getTotalWage());
    }
}