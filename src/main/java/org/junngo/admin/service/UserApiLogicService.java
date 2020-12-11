package org.junngo.admin.service;

import org.junngo.admin.domain.enumclass.UserStatus;
import org.junngo.admin.domain.network.Header;
import org.junngo.admin.domain.network.request.UserApiRequest;
import org.junngo.admin.domain.network.response.UserApiResponse;
import org.junngo.admin.domain.user.User;
import org.junngo.admin.domain.user.UserRepository;
import org.junngo.admin.web.api.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

//  1. request data
//  2. user 생성
//  3. 생성된 데이터 리턴 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
//      1. request data
        UserApiRequest userApiRequest = request.getData();

//      2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

//      3. 생성된 데이터 리턴
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
//      id -> getOne
        Optional<User> optional = userRepository.findById(id);

//      user -> userApiResponse return
        return optional
                .map(user -> response(user))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 데이터 를 찾고
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            // 3. data -> update
            // id
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt())
            ;
            return user;

        })
                .map(user -> userRepository.save(user))             // update -> newUser
                .map(user -> response(user))                        // userApiResponse
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        // 1. id -> repository -> user
        Optional<User> optional = userRepository.findById(id);

        // 2. repository -> delete
        return optional.map(user ->{
            userRepository.delete(user);
            return Header.OK();
        })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<UserApiResponse> response(User user) {
//      user -> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .build();

//      Header + data return
        return Header.OK(userApiResponse);
    }
}
