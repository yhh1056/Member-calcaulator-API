package com.yhh.membercalculator.dto;

import com.yhh.membercalculator.model.WorkTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Getter
public class TimeDto {
    private static final int wage = 8720;
    private static final double optionWage = 1.2;

    private List<Integer> times = new ArrayList<>();
    private int totalWage = 0;

    public TimeDto(List<WorkTime> workTimes) {
        addWeekTimes(workTimes);
    }

    private void addWeekTimes(List<WorkTime> workTimes) {
        calculateWage(workTimes);
        calculateTotalWage(times);
    }

    private void calculateWage(List<WorkTime> workTimes) {
        workTimes.forEach(this::checkOptionToCalculate);
    }

    private void checkOptionToCalculate(WorkTime workTime) {
        isOption(workTime);
        isNotOption(workTime);
    }

    private void isOption(WorkTime workTime) {
        if (workTime.isOptionCheck()) {
            times.add(calculateOptionWage(workTime));
        }
    }

    private void isNotOption(WorkTime workTime) {
        if (!workTime.isOptionCheck()){
            times.add(calculateWage(workTime));
        }
    }

    private int calculateOptionWage(WorkTime workTime) {
        return (int) (workTime.getWorkTime() * wage * optionWage);
    }

    private int calculateWage(WorkTime workTime) {
        return workTime.getWorkTime() * wage;
    }

    private void calculateTotalWage(List<Integer> times) {
        times.forEach(workWage -> totalWage += workWage);
    }
}
