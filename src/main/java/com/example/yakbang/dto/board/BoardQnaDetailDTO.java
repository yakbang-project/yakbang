package com.example.yakbang.dto.board;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class BoardQnaDetailDTO {
   private Long questionId;   // 질문번호
   private Long memberId;     // 회원번호
   private Long pillId;       // 약번호
   private String title;      // 제목
   private String content;    // 내용
   private Long viewCount;    // 조회수
   private LocalDate writeDate;  // 작성날짜
   private String answerContent; // 전문가 답변 내용
   private LocalDate answerDate; // 답변 날짜
   private Long answerNo;     // 답변 번호
   private String name;       // 회원 이름
   private String expertName; // 전문가 이름
   private String job;        // 전문가 직업
   private String pharmacyAddress;    // 전문가 주소
   private Long expertId;     // 전문가 번호


}
