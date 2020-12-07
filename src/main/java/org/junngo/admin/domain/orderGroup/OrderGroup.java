package org.junngo.admin.domain.orderGroup;

import lombok.*;
import lombok.experimental.Accessors;
import org.junngo.admin.domain.orderDetail.OrderDetail;
import org.junngo.admin.domain.user.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"user", "orderDetailList"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Builder
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

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

//    OrderGroup N : 1 User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

//    OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
