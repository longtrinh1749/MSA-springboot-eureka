package com.shopeefood.clone.demo.repository;

import com.shopeefood.clone.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "select " +
                    "case when(count(u) > 0) then true else false end " +
                    "from AppUser u where u.username = ?1")
    boolean isUsernameExisted(String username);

    @Query(value = "select u from AppUser u where u.username = ?1")
    List<AppUser> findAllByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update AppUser u set u.authenToken = ?1 where u.username = ?2")
    void updateSessionAndToken(String token, String username);
}
