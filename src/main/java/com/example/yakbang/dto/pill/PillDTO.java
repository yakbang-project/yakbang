package com.example.yakbang.dto.pill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class PillDTO {
    // e-약은요
    @JsonProperty("entpName")
    private String companyName; // 제조사
    @JsonProperty("itemName")
    private String pillName; // 제품명
    private String itemSeq; // 상품시퀀스
    @JsonProperty("efcyQesitm")
    private String detailContent; // 효능
    @JsonProperty("useMethodQesitm")
    private String pillHowto; // 섭취방법
    @JsonProperty("atpnWarnQesitm")
    private String intakePrecautions;// 섭취시주의사항
    @JsonProperty("atpnQesitm")
    private String atpnQesitm; // 주의사항
    @JsonProperty("intrcQesitm")
    private String intrcQesitm; // 상호작용
    @JsonProperty("seQesitm")
    private String seQesitm;  // 부작용
    @JsonProperty("depositMethodQesitm")
    private String pillDeposit; // 보관방법
    @JsonProperty("openDe")
    private String openDate; // 공개 일자
    @JsonProperty("updateDe")
    private String updateDate; // 수정 날짜

    // 의약품 낱알식별 정보
    @JsonProperty("COLOR_CLASS1")
    private String pillColor; // 색상
    @JsonProperty("SHAPE")
    private String pillShape; // 형태
    @JsonProperty("itemImage")
    private String pillImage ; // 약 이미지


}
