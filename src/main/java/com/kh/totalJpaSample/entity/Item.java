package com.kh.totalJpaSample.entity;

import com.kh.totalJpaSample.Constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item") // 엔티티와 맵핑 할 테이블을 지정
public class Item {
    @Id // 테이블의 기본 키 지정
    @Column(name = "item_id") // 필드와 컬럼을 맵핑
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA가 자동으로 생성 전략을 결정
    private Long id; // 상품 코드

    @Column(nullable = false, length = 50) // NULL을 허용하지 않고 길이를 50자로 제한
    private String itemName; // 상품명 item_name

    @Column(name="price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

    @Enumerated(EnumType.STRING)  // enum으로 정의 된 값을 문자열 그대로 DB에 저장
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; // 수정 시간


}
