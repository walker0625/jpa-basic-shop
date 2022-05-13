package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Locker extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
