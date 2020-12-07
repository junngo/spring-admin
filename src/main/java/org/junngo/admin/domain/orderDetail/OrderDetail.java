package org.junngo.admin.domain.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junngo.admin.domain.item.Item;
import org.junngo.admin.domain.orderGroup.OrderGroup;
import org.junngo.admin.domain.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString(exclude = {"orderGroup", "item"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

//  OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;

//  OrderDetail N : 1 Item
    @ManyToOne
    private Item item;

////    N : 1
//    @ManyToOne
//    private User user;
//
////    N : 1
//    @ManyToOne
//    private Item item;
}
