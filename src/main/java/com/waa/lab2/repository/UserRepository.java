package com.waa.lab2.repository;

import com.waa.lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :minNumberOfPosts")
    List<User> findByPostsSizeGreaterThan(@Param("minNumberOfPosts") int minNumberOfPosts);

}
