package org.junngo.admin.domain.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junngo.admin.domain.enumclass.OrderType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderGroupApiRequest {

    private Long id;

    private String status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private String paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;
}
