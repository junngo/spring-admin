package org.junngo.admin.domain.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junngo.admin.domain.orderDetail.OrderDetail;
import org.junngo.admin.domain.orderDetail.OrderDetailRepository;
import org.junngo.admin.domain.orderGroup.OrderGroup;
import org.junngo.admin.domain.orderGroup.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        String account = "test";
        String password = "test123";
        String status = "REGISTERED";
        String email = "test@gmail.com";
        String phoneNumber = "010-1234-5678";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        System.out.println(newUser);
        Assert.assertNotNull(newUser);
    }

    @Test
    public void read() {
        String account = "test";
        String password = "test123";
        String status = "REGISTERED";
        String email = "test@gmail.com";
        String phoneNumber = "010-1234-5678";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

//      OrderGroup Set Start
        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType("ALL");
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");

//      OrderDetail Set Start
        orderGroup.setOrderDetailList(new ArrayList<>());

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
//        orderDetail.setItemId(1L);
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        orderGroup.getOrderDetailList().add(newOrderDetail);
//      OrderDetail Set End

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        user.setOrderGroupList(new ArrayList<>());
        user.getOrderGroupList().add(newOrderGroup);
//      OrderGroup Set End

        User newUser = userRepository.save(user);
        User findUser = userRepository.findByPhoneNumberOrderByIdDesc(phoneNumber);

        Assert.assertEquals(findUser.getPhoneNumber(), phoneNumber);

        newUser.getOrderGroupList().stream().forEach(og -> {
            System.out.println("---------------주문 묶음----------------");
            System.out.println("수령인: " + og.getRevName());
            System.out.println("수령지: " + og.getRevAddress());
            System.out.println("총금액: " + og.getTotalPrice());
            System.out.println("총수량: " + og.getTotalQuantity());

            System.out.println("---------------주문 상세----------------");
            og.getOrderDetailList().forEach(od -> {
                System.out.println("주문의 상태: " + od.getStatus());
                System.out.println("도착 예정 일자: " + od.getArrivalDate());
            });
        });

//        Optional<User> findUser = userRepository.findById(1L);
//        findUser.ifPresent(selectUser -> {
//            System.out.println(selectUser);
//            System.out.println(selectUser.getEmail());
//
//            selectUser.getOrderDetailList().stream().forEach(detail -> {
//                System.out.println(detail.getItem());
//            });
//        });
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