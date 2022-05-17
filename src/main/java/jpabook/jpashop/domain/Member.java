package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @Embedded
    private Period period;

    @Embedded
    private Address homeAddress;

    @ElementCollection // 기본은 지연로딩
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID")) // 외래키 설정
    @Column(name = "FOOD_NAME") // 필드 하나라 예외적으로 가능
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection // 기본은 지연로딩
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    /*@Embedded
    @AttributeOverrides({})
    private Address workAddress;*/
}
