package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.WorkTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2021/01/13
 */
class WorkTimeDtoTest {

    @Test
    @DisplayName("시급이 계산되어 나오는지")
    void calculate() {
        List<WorkTime> workTimes = new ArrayList<>();
        workTimes.add(new WorkTime(1, 10, false));
        workTimes.add(new WorkTime(2, 10, false));
        workTimes.add(new WorkTime(3, 10, false));
        workTimes.add(new WorkTime(4, 15, true));
        workTimes.add(new WorkTime(5, 15, true));

        int totalWage = 0;
        for (WorkTime workTime : workTimes) {
            totalWage += workTime.getWeekWage();
        }
        Assertions.assertEquals(575520, totalWage);
    }

}