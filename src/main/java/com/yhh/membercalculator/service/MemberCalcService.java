package com.yhh.membercalculator.service;

import com.yhh.membercalculator.dto.WorkTimeDto;
import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.model.WorkTime;
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

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void create(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        Member member = memberRepository.findById(memberId);
        if (member == null) {
            throw new NullPointerException();
        }
        return member;
    }

    public void updateWorkTime(Long memberId, List<WorkTimeDto> workTimeDtos) {
        for (WorkTimeDto workTimeDto : workTimeDtos) {
            Member member = memberRepository.findById(memberId);
            WorkTime workTime = new WorkTime(workTimeDto.getWeek(), workTimeDto.getWorkTime(),
                workTimeDto.isVacationPay());
            member.addWorkTime(workTime);
            memberRepository.save(member);
        }
    }

    @Transactional
    public void updateMember(Long id, String name) {
        Member member = memberRepository.findById(id);
        member.changeName(name);
        memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id);
        memberRepository.remove(member);
    }
}
