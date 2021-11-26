package com.shopeefood.clone.demo.repository;

import com.shopeefood.clone.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "select " +
                    "case when(count(u) > 0) then true else false end " +
                    "from AppUser u where u.username = ?1")
    boolean isUsernameExisted(String username);

    @Query(value = "select u from AppUser u where u.username = ?1")
    List<AppUser> findAllByUsername(String username);

    @Query(value = "update AppUser u set u.sessionId = ?1, u.authenToken = ?2 where u.username = ?3")
    void updateSessionAndToken(String sessionId, String token, String username);
}
