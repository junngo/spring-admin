package org.junngo.admin.domain.network.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junngo.admin.domain.enumclass.ItemStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemApiResponse {

    private Long id;

    private ItemStatus status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private Long partnerId;

}
