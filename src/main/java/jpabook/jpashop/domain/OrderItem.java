package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Data
@Entity
public class OrderItem extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    //@Column(name ="ORDER_ID")
    //private Long orderId;

    //@Column(name ="ITEM_ID")
    //private Long itemId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;
}
