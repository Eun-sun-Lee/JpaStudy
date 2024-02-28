package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    // 상품의 공통 속성
    private Long id; // 상품 수정을 위해 id값 추가

    private String name;
    private int price;
    private int stockQuantity;

    // 책과 관련된 특별한 속성
    private String author;
    private String isbn;
}
