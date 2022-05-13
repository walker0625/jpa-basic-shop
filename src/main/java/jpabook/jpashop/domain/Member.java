package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

}
