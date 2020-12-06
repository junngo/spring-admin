package org.junngo.admin.domain.orderDetail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junngo.admin.domain.item.Item;
import org.junngo.admin.domain.item.ItemRepository;
import org.junngo.admin.domain.user.User;
import org.junngo.admin.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());


        User user = new User();
        user.setAccount("test");
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test");
        User newUser = userRepository.save(user);

        orderDetail.setUserId(newUser.getId());


        Item item = new Item();
        item.setName("Laptop");
        item.setPrice(100000);
        item.setContent("Samsung Laptop");

        Item newItem = itemRepository.save(item);
        orderDetail.setItemId(newItem.getId());

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}
