package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name ="ORDER_ITEM_ID")
    private Long id;

    //@Column(name ="ORDER_ID")
    //private Long orderId;

    //@Column(name ="ITEM_ID")
    //private Long itemId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;


    private int orderPrice;
    private int count;
}
