package com.erikalves.application.repositories;


import com.erikalves.application.model.User;
import com.erikalves.application.utils.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired(required = true)
    UserRepository repository;

    User createdUser;

    Long existingUserId =1l;

    @Before
    public void begin() {

        createdUser = new User();
       createdUser.setUserName("Erik Alves");
        createdUser.setUserLimitCredit(new BigDecimal("100.00"));
        createdUser.setUserRisk("B");
        Util.interestCalculation(createdUser);

    }


    @Test
    public void shouldCreateUpdateDeleteProduct() {

        shouldCreateProduct();
        shouldUpdateProduct();
        shouldDeleteProduct();
    }

    public void shouldCreateProduct() {

        User localUser = repository.save(createdUser);
        LOGGER.debug("saved entity ID {}", localUser);
        Assert.assertNotNull(localUser.getUserId());


    }

    public void shouldDeleteProduct() {

        Long id = createdUser.getUserId();
        repository.delete(id);
        User deletedUser = repository.findOne(id);
        Assert.assertEquals(null, deletedUser);

    }


    public void shouldUpdateProduct() {

        createdUser.setUserRisk("C");
        createdUser.setUserName("Name updated by JUNIT - John Doe is my name now");
        User updatedUser = repository.save(createdUser);
        Assert.assertTrue(null != updatedUser);
        Assert.assertTrue("Name updated by JUNIT - John Doe is my name now".equals(updatedUser.getUserName()));
    }



    @Test
    public void findSpecificUser() {


        User findUser = repository.getOne(existingUserId);
        Assert.assertTrue(null != findUser);
        LOGGER.debug(" *** RESULT *** {}", findUser.toString());

    }


    @Test
    public void findAllIncludingRelationships()  {

        List<User> list = repository.findAll();

        Assert.assertTrue(null != list);
        for(User user: list){
            Assert.assertTrue(null != user);
            Assert.assertTrue(null != user.getUserId());
            LOGGER.debug(" *** RESULT *** {}", user.toString());
        }

    }



}