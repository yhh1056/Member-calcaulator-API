package com.yhh.membercalculator.controller;

import com.yhh.membercalculator.dto.MemberDto;
import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.service.MemberCalcService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCalcService memberCalcService;

    @GetMapping("/members")
    public ResponseEntity<java.util.List<Member>> getMembers() {
        return new ResponseEntity<>(memberCalcService.getAllMembers(), HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity<?> addMember(@RequestBody @Valid MemberDto memberDto) {
        memberCalcService.create(memberDto.toEntity());
        return ResponseEntity.ok("resource updated");
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") Long id) {
        final Member member = memberCalcService.findMember(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/members/{id}")
    public ResponseEntity<?> updateMemberWorkTime(@PathVariable("id") Long id,
            @RequestBody @Valid MemberDto memberDto) {
        memberCalcService.updateWorkTime(id, memberDto);
        return ResponseEntity.ok("resource updated");
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id) {
        memberCalcService.deleteMember(id);
        return ResponseEntity.ok("resource delete");
    }
}
