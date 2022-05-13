package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    
    // 중간 테이블을 생성(다대다 해결 방법으로 추천되지는 않음)
    @ManyToMany()
    @JoinTable(
               name = "CATEGORY_ITEM",
               joinColumns = @JoinColumn(name = "CATEGORY_ID"),
               inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
              )
    private List<Item> items = new ArrayList<>();
}
