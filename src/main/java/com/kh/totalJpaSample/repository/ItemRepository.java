package com.kh.totalJpaSample.repository;

import com.kh.totalJpaSample.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 기본적인 CRUD는 JpaRepository에 이미 정의 되어 있음. 페이징 처리도 포함 되어 있음.
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String itemName);
    // OR 조건 처리
    List<Item> findByItemNameOrItemDetail(String itemNm, String itemDetail);

    // LessThan 조건 처리 : Price 변수보다 작은 상품 데이터를 조회하는 쿼리
    List<Item> findByPriceLessThan(Integer Price);

    // OrderBy로 정렬하기
    List<Item> findAllByOrderByPriceDesc();

    //JPQL 작성하기 : SQL과 유사한 객체지향 쿼리 언어
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> priceSorting(@Param("itemDetail") String itemDetail);

    //nativeQuery 사용하기
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc",
            nativeQuery=true)
    List<Item> priceSortingNative(@Param("itemDetail") String itemDetail);

}
