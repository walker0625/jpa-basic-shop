package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("M") // DTYPE 값을 바꿈(기본값은 Entity 명 - Movie)
public class Movie extends Item{
    private String director;
    private String actor;
}
