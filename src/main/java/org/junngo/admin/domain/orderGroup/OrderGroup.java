package org.junngo.admin.domain.orderGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junngo.admin.domain.orderDetail.OrderDetail;
import org.junngo.admin.domain.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"user", "orderDetailList"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderGroup {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String status;

    private String orderType;   // 주문의 형태: 일괄 / 개별

    private String revAddress;

    private String revName;

    private String paymentType; // 카드 / 현금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

//    OrderGroup N : 1 User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

//    OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
