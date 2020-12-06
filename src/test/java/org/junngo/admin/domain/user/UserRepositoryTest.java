package org.junngo.admin.domain.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("test");
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test");

        User newUser = userRepository.save(user);

        System.out.println(newUser);
    }

    @Test
    public void read() {
        User user = new User();
        user.setAccount("test");
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test");

        User newUser = userRepository.save(user);

        Optional<User> findUser = userRepository.findById(1L);
        findUser.ifPresent(selectUser -> {
            System.out.println(selectUser);
            System.out.println(selectUser.getEmail());

            selectUser.getOrderDetailList().stream().forEach(detail -> {
                System.out.println(detail.getItem());
            });
        });
    }

    @Test
    public void update() {
        User user = new User();
        user.setAccount("test");
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test");

        User newUser = userRepository.save(user);

        Optional<User> findUser = userRepository.findById(newUser.getId());
        findUser.ifPresent(selectUser -> {
            selectUser.setAccount("test1");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method");
            userRepository.save(selectUser);

            System.out.println(selectUser);
            System.out.println(selectUser.getEmail());
        });
    }

    @Test
    @Transactional
    public void delete() {
        User user = new User();
        user.setAccount("test");
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test");

        User newUser = userRepository.save(user);

        Optional<User> findUser = userRepository.findById(newUser.getId());
        findUser.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(newUser.getId());
        Assert.assertFalse(deleteUser.isPresent());
    }

}