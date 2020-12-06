package org.junngo.admin.domain.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junngo.admin.domain.item.Item;
import org.junngo.admin.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString(exclude = {"user", "item"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private LocalDateTime orderAt;

//    N : 1
    @ManyToOne
    private User user;

//    N : 1
    @ManyToOne
    private Item item;
}
