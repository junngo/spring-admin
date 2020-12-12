package org.junngo.admin.web.api;

import org.junngo.admin.domain.item.Item;
import org.junngo.admin.domain.network.request.ItemApiRequest;
import org.junngo.admin.domain.network.response.ItemApiResponse;
import org.junngo.admin.service.ItemApiLogicService;
import org.junngo.admin.web.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RequestMapping("/api/item")
@RestController
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

//    @Autowired
//    private ItemApiLogicService itemApiLogicService;
//
//    @PostConstruct
//    public void init() {
//        this.baseService = itemApiLogicService;
//    }


//    @Override
//    @PostMapping("")    // /api/item
//    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
//
//        return itemApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}") // /api/item/8
//    public Header<ItemApiResponse> read(@PathVariable Long id) {
//
//        return itemApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("")     // /api/item
//    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
//
//        return itemApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}")  // /api/item/3
//    public Header delete(@PathVariable Long id) {
//
//        return itemApiLogicService.delete(id);
//    }
}
