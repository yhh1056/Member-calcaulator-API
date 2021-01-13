package com.yhh.membercalculator;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Repository
@RequiredArgsConstructor
public class WorkTimeRepository {

    private final EntityManager em;


}
