package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded // 내장 type 포함
    private Address address;

    @OneToMany(mappedBy = "member") // 일대다 (Member - One), 하나의 회원이 여러 개의 상품 주문 -> Order 테이블에 있는 member field에 의해 매핑됨.
    private List<Order> orders = new ArrayList<>();

}
