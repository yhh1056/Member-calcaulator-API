package com.yhh.membercalculator.dto;

import java.util.ArrayList;
import java.util.List;
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
public class WorkTimes {
    private List<Integer> times = new ArrayList<>();
    private List<Boolean> options = new ArrayList<>();
}
