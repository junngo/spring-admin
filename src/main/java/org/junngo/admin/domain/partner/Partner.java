package org.junngo.admin.domain.partner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junngo.admin.domain.category.Category;
import org.junngo.admin.domain.item.Item;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"itemList", "category"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partner {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

//    Partner N : 1 Category
    @ManyToOne
    private Category category;

//    Partner 1 : N Item
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "partner")
    private List<Item> itemList;

}
