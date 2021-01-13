package com.yhh.membercalculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2021/01/13
 */
class TimeTest {

    @Test
    @DisplayName("근무 시간이 생성되는지")
    void create() {
        WorkTime workTime = new WorkTime(1, 15, true);

        assertNotNull(workTime);
        assertEquals(15, workTime.getWorkTime());
    }
}
