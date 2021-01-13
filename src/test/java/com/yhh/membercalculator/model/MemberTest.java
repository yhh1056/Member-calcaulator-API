package com.yhh.membercalculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2021/01/13
 */
class MemberTest {

    @Test
    @DisplayName("멤버가 생성되는지")
    void create() {
        Member member = new Member("tester");

        assertNotNull(member);
        assertEquals("tester", member.getName());
    }

    @Test
    @DisplayName("근무시간이 주입되는지")
    void setWorkTime() {
        List<WorkTime> workTimes = List.of(
                new WorkTime(10, true),
                new WorkTime(10, true),
                new WorkTime(10, true));

        Member member = new Member("tester");
        member.setWorkTimes(workTimes);

        Assertions.assertEquals(3, member.getWorkTimes().size());
    }
}