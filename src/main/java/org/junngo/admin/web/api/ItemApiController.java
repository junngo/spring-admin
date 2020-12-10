package org.junngo.admin.web.api;

import org.junngo.admin.domain.network.Header;
import org.junngo.admin.domain.network.request.ItemApiRequest;
import org.junngo.admin.domain.network.response.ItemApiResponse;
import org.junngo.admin.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/item")
@RestController
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("")    // /api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {

        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/item/8
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("")     // /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")  // /api/item/3
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
