package com.yhh.membercalculator.repository;

import com.yhh.membercalculator.model.Member;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public Member findById(Long id) {
        return entityManager.find(Member.class, id);
    }

    public void save(Member member) {
        entityManager.persist(member);
    }

    public List<Member> findAll() {
        return entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }

    public void delete(Member member) {
        entityManager.remove(member);
    }
}
