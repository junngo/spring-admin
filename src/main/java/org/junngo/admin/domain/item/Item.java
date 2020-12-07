package org.junngo.admin.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junngo.admin.domain.orderDetail.OrderDetail;
import org.junngo.admin.domain.partner.Partner;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"orderDetailList", "partner"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

//    Item N : 1 Partner
    @ManyToOne
    private Partner partner;

//    Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

////    1 : N
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;

}
