package com.yhh.membercalculator.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Entity
@Getter
@NoArgsConstructor
public class WorkTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int workTime;

    private boolean optionCheck;

    private int weekWage;

    public WorkTime(int workTime, boolean optionCheck) {
        this.workTime = workTime;
        this.optionCheck = optionCheck;
    }
}
