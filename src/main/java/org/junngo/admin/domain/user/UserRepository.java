package org.junngo.admin.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    SELECT * FROM user WHERE account = ?
    Optional<User> findByAccount(String account);

//    SELECT * FROM user WHERE email = ?
    Optional<User> findByEmail(String Email);

//    SELECT * FROM user WHERE account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);

//    SELECT * FROM user WHERE phone_number = ? ORDER BY id desc
    User findByPhoneNumberOrderByIdDesc(String phoneNumber);
}
