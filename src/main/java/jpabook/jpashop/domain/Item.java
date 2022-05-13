package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // 정규화
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 반정규화
@DiscriminatorColumn(name = "CHILD_TYPE") // DTYPE(Movie, Album, Book) > ITEM 테이블만 봐서는 해당 ROW가 무엇의 정보인지 모르므로 필요, 관례는 DTYPE 이름 그대로 씀
public abstract class Item extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
