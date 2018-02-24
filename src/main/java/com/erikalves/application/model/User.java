package com.erikalves.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="USER")
public class User implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column (name = "USER_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @NotNull
    @Column (name = "USER_LIMIT_CREDIT")
    private BigDecimal userLimitCredit;

    @NotNull
    @Column (name = "USER_RISK")
    private String userRisk;



    public User() {
    }


    public User(String userName, BigDecimal userLimitCredit, String userRisk) {
        this.userName = userName;
        this.userLimitCredit = userLimitCredit;
        this.userRisk = userRisk;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getUserLimitCredit() {
        return userLimitCredit;
    }

    public void setUserLimitCredit(BigDecimal userLimitCredit) {
        this.userLimitCredit = userLimitCredit;
    }

    public String getUserRisk() {
        return userRisk;
    }

    public void setUserRisk(String userRisk) {
        this.userRisk = userRisk;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                "name='" + userName + '\'' +
                "limitCredit='" + userLimitCredit + '\'' +
                "risk='" + userRisk + '\'' +

                '}';
    }
}
