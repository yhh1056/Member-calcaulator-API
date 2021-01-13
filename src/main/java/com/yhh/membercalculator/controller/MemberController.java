package com.yhh.membercalculator.controller;

import com.yhh.membercalculator.dto.MemberDto;
import com.yhh.membercalculator.model.Member;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@RestController
public class MemberController {

    @GetMapping("/members")
    public ResponseEntity<List<MemberDto>> getMembers() {
        /**
         * todo: 디비에 연결해서 값 가져오기
         */
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity<?> addMember(@RequestBody @Valid MemberDto memberDto) {

        Member member = memberDto.toEntity(memberDto.getName());
        System.out.println(member.getName());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
