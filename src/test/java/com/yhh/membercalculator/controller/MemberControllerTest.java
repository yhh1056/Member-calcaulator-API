package com.yhh.membercalculator.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhh.membercalculator.dto.MemberDto;
import com.yhh.membercalculator.model.Member;
import com.yhh.membercalculator.model.WorkTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author yhh1056
 * @since 2021/01/13
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberController memberController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("/members json형태로 반환되는지")
    void getMemberJsonData() throws Exception {
        List<WorkTime> workTimes = List.of(
            new WorkTime(10, true),
            new WorkTime(10, true),
            new WorkTime(10, true),
            new WorkTime(10, true));

        Member member = new Member("tester");
        member.setWorkTimes(workTimes);

        List<MemberDto> members = new ArrayList<>();
        members.add(new MemberDto(member));

        when(memberController.getMembers())
            .thenReturn(new ResponseEntity<>(members, HttpStatus.OK));

        mockMvc.perform(get("/members"))
            .andExpect(status().isOk())
            .andExpect(content().string("[{\"id\":null,"
                + "\"name\":\"tester\","
                + "\"workWages\":{\"times\":[104640,104640,104640,104640],"
                + "\"totalWage\":418560}}]"));
    }

    @Test
    @DisplayName("/members 멤버 데이터를 이용하여 멤버 생성")
    void createMember() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setName("tester");

        when(memberController.addMember(memberDto)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED
        ));

        mockMvc.perform(post("/members")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(memberDto)))
            .andExpect(status().isOk())
            .andDo(print());
    }
}