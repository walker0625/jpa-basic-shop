package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class Period {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Period() {
    }

    public Period(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
