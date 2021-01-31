package com.yhh.membercalculator.service;

import com.yhh.membercalculator.dto.MemberDto;
import com.yhh.membercalculator.dto.WorkTimeDto;
import com.yhh.membercalculator.exception.ResourceNotFoundException;
import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.model.WorkTime;
import com.yhh.membercalculator.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(MemberCalcService.class);

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void create(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        findMemberById(memberId);
        Member member = findMemberById(memberId);
        if (member == null) {
            throw new ResourceNotFoundException();
        }
        return member;
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new ResourceNotFoundException());
    }

    @Transactional
    public void updateWorkTime(Long memberId, MemberDto memberDto) {
        Member member = findMemberById(memberId);
        if (!memberDto.getName().equals(member.getName())) {
            member.changeName(memberDto.getName());
        }

        final List<WorkTimeDto> workTimes = memberDto.getWorkTimes();
        for (WorkTimeDto workTimeDto : workTimes) {
            if (member.isExistWeekNumber(workTimeDto.getWeekNumber())) {
                throw new IllegalArgumentException("같은 주가 존재합니다.");
            }
            WorkTime workTime = new WorkTime(workTimeDto.getWeekNumber(), workTimeDto.getWorkTime(), workTimeDto.isVacationPay());
            member.addWorkTime(workTime);
            memberRepository.save(member);
        }

    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = findMemberById(memberId);
        memberRepository.remove(member);
    }
}
