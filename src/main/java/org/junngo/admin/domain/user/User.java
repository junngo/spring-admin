package org.junngo.admin.domain.user;

import lombok.*;
import lombok.experimental.Accessors;
import org.junngo.admin.domain.orderDetail.OrderDetail;
import org.junngo.admin.domain.orderGroup.OrderGroup;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"orderGroupList"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

//    User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

}
