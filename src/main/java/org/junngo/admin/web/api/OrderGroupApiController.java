package org.junngo.admin.web.api;

import org.junngo.admin.domain.network.Header;
import org.junngo.admin.domain.network.request.OrderGroupApiRequest;
import org.junngo.admin.domain.network.response.OrderGroupApiResponse;
import org.junngo.admin.domain.orderGroup.OrderGroup;
import org.junngo.admin.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RequestMapping("/api/orderGroup")
@RestController
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    @PostMapping("")    // /api/orderGroup
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
        return orderGroupApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/orderGroup/3
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        return orderGroupApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        return orderGroupApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return orderGroupApiLogicService.delete(id);
    }
}
