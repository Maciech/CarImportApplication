package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
    boolean existsByUserMail(String userMail);
    boolean existsByUserNickName(String userNickName);
    boolean existsByUserMailAndUserPassword(String userMail, String userPassword);


}
