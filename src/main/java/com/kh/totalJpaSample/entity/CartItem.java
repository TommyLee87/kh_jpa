package com.kh.totalJpaSample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne // 여러 개의 상품이 하나의 장바구니에 담김. (다대일 관계) One 쪽이 주인이다!!
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne // 하나의 아이템이 여러 장바구니에 상품으로 담길 수 있음. (다대일 관계) One 쪽이 주인이다!!
    @JoinColumn(name="item_id")
    private Item item;

    private int count;
}
