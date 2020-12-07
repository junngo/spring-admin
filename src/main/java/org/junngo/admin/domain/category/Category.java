package org.junngo.admin.domain.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junngo.admin.domain.partner.Partner;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"partnerList"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String type;

    private String title;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

//    Category 1 : N Partner
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Partner> partnerList;
}
