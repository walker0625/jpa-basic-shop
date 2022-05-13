package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass // 공통 슈퍼클래스 > DB에는 반영되지 않고, 부모의 역할을 하는 것이 아님(단순 공통 필드), Entity 자체로 사용 불가() - 추상 클래스 추천
public abstract class BaseEntity {

    // 모든 entity에 필요함
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

}
