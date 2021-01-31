package com.yhh.membercalculator.controller;

import com.yhh.membercalculator.service.MemberCalcService;
import com.yhh.membercalculator.dto.MemberDto;
import com.yhh.membercalculator.dto.WorkTimeDto;
import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.model.WorkTime;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yhh1056
 * @since 2021/01/13
 */

@Api(tags = {"1. Member"})
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCalcService memberCalcService;

    @ApiOperation(value = "전체 회원 정보 조회", notes = "게시판에 나타낼 모든 회원 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMembers() {
        return new ResponseEntity(memberCalcService.getAllMembers(), HttpStatus.OK);
    }

    @ApiOperation(value = "회원 추가", notes = "이름으로 회원을 추가합니다.")
    @PostMapping("/members")
    public ResponseEntity<?> addMember(@RequestBody @Valid MemberDto memberDto) {
        memberCalcService.create(memberDto.toEntity());
        return ResponseEntity.ok("resource updated");
    }

    @ApiOperation(value = "id로 회원 조회", notes = "id로 회원을 조회합니다.")
    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") Long id) {
        final Member member = memberCalcService.findMember(id);
        return new ResponseEntity(member, HttpStatus.OK);
    }

    @ApiOperation(value = "회원 id로 근무시간 추가하기", notes = "id로 근무시간과 주휴수당여부를 추가합니다.")
    @PostMapping("/members/{id}")
    public ResponseEntity<?> updateMemberWorkTime(@PathVariable("id") Long id,
            @RequestBody @Valid MemberDto memberDto) {
        memberCalcService.updateWorkTime(id, memberDto);
        return ResponseEntity.ok("resource updated");
    }

//    @ApiOperation(value = "회원 id로 이름 변경", notes = "id로 회원의 이름을 변경합니다.")
//    @PatchMapping("/members/{id}")
//    public ResponseEntity<?> updateMemberName(@PathVariable("id") Long id, @RequestBody @Valid MemberDto memberDto) {
//        memberCalcService.updateMember(id, memberDto.getName());
//        return ResponseEntity.ok("resource updated");
//    }

    @ApiOperation(value = "회원 id로 회원 삭제", notes = "id로 회원을 삭제합니다.")
    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id) {
        memberCalcService.deleteMember(id);
        return ResponseEntity.ok("resource delete");
    }
}
