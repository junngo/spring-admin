package org.junngo.admin.domain.orderDetail;

import lombok.*;
import lombok.experimental.Accessors;
import org.junngo.admin.domain.item.Item;
import org.junngo.admin.domain.orderGroup.OrderGroup;
import org.junngo.admin.domain.user.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString(exclude = {"orderGroup", "item"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Builder
@Entity
public class OrderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
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
