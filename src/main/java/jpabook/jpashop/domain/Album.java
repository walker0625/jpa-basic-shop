package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("A") // DTYPE 값을 바꿈(기본값은 Entity 명 - Album)
public class Album extends Item{
    private String artist;
    private String etc;
}
