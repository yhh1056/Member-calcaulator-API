package com.yhh.membercalculator.controller;

import com.yhh.membercalculator.dto.MemberDto;
import com.yhh.membercalculator.model.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = {"1. Member"})
@RestController
public class MemberController {

    @ApiOperation(value = "전체 회원 정보 조회", notes = "게시판에 나타낼 모든 회원 정보를 조회합니다.")
    @GetMapping("/members")
    public ResponseEntity<List<MemberDto>> getMembers() {
        /**
         * todo: 디비에 연결해서 값 가져오기
         */
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @ApiOperation(value = "회원 추가", notes = "이름으로 회원을 추가합니다.")
    @PostMapping("/members")
    public ResponseEntity<?> addMember(@RequestBody @Valid MemberDto memberDto) {

        Member member = memberDto.toEntity(memberDto.getName());
        System.out.println(member.getName());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
