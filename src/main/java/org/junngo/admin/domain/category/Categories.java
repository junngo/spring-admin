package org.junngo.admin.domain.category;

import lombok.*;
import lombok.experimental.Accessors;
import org.junngo.admin.domain.partner.Partner;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString(exclude = {"partnerList"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Builder
@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String title;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // Category 1 : N Partner
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Partner> partnerList;
}
