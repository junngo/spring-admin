package org.junngo.admin.domain.item;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = new Item();
        item.setName("Laptop");
        item.setPrice(100000);
        item.setContent("Samsung Laptop");

        Item newItem = itemRepository.save(item);

        Assert.assertNotNull(newItem);
    }

    @Test
    public void read() {
        Item item = new Item();
        item.setName("Laptop");
        item.setPrice(100000);
        item.setContent("Samsung Laptop");

        Item newItem = itemRepository.save(item);

        Optional<Item> findItem = itemRepository.findById(newItem.getId());
        findItem.ifPresent(selectItem -> {
            System.out.println(selectItem);
        });
        Assert.assertTrue(findItem.isPresent());

    }
}