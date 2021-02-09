package com.yhh.membercalculator.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name = "work_time")
public class WorkTime {

    private static final int PAY = 8720;
    private static final double VACATION_POLICY = 1.2;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "work_time_id")
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;

    private int weekNumber;

    private int workTime;

    private boolean isVacationPay;

    private int weekWage;

    public WorkTime(int weekNumber, int workTime, boolean isVacationPay) {
        this.weekNumber = weekNumber;
        this.workTime = workTime;
        this.isVacationPay = isVacationPay;
        this.weekWage = calcPay(workTime, isVacationPay);
    }

    private int calcPay(int workTime, boolean isVacationPay) {
        if (isVacationPay) {
            return (int) (workTime * PAY * VACATION_POLICY);
        }
        return workTime * PAY;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
