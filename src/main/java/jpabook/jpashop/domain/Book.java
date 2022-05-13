package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("B") // DTYPE 값을 바꿈(기본값은 Entity 명 - Book)
public class Book extends Item{
    private String author;
    private String isbn;
}
