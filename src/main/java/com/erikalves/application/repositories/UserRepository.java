package com.erikalves.application.repositories;


import com.erikalves.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT p FROM USER p where p.userName = :userName")
    User findUserByName(@Param("userName") String userName);

}
