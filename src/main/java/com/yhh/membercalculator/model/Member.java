package com.yhh.membercalculator.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member", cascade = ALL)
    @JsonManagedReference
    private List<WorkTime> workTimes = new ArrayList<>();

    private int totalWage;

    public Member(String name) {
        this.name = name;
    }

    public void addWorkTime(WorkTime workTime) {
        if (workTimes.size() >= 6) {
            throw new IllegalArgumentException();
        }
        workTime.setMember(this);
        workTimes.add(workTime);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public int calcTotalWage() {
        totalWage = 0;
        for (WorkTime workTime : workTimes) {
            totalWage += workTime.getWeekWage();
        }
        return totalWage;
    }

    public boolean isExistWeekNumber(int weekNumber) {
        return workTimes.stream()
                    .noneMatch(workTime -> workTime.getWeekNumber() == weekNumber);
    }
}
