package com.kh.totalJpaSample.entity;

import com.kh.totalJpaSample.Constant.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue // 기본 생성전략은 AUTO
    @Column(name = "order_id")
    private Long id;

    @ManyToOne // 한 회원이 여러 개의 주문을 할 수 있다. (다대일 관계) One쪽이 주인!!
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "order") // 연관 관계의 주인이 아님을 표시함.
    private List<OrderItem> orderItemList = new ArrayList<>();
}
