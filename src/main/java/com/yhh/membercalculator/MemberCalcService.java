package com.yhh.membercalculator;

import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCalcService {

    private final MemberRepository memberRepository;
    private final WorkTimeRepository workTimeRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void create(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
