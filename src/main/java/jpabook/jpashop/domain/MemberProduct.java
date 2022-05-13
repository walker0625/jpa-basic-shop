package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

// 다대다 관계를 풀기위한 별도의 엔티티(다른 속성도 추가가 가능해짐)
@Data
@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;
    private LocalDateTime orderDateTime;
}
