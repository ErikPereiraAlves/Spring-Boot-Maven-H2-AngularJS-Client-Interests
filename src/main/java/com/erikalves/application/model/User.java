package com.erikalves.application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

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
    private BigDecimal userLimitCredit = new BigDecimal("0.00");

    @NotNull
    @Column (name = "USER_RISK")
    private String userRisk;

    @NotNull
    @Column (name = "USER_INTEREST")  // interest = taxa de juros
    private Double userInterest=0.0;


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

    public Double getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(Double userInterest) {
        this.userInterest = userInterest;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                "name='" + userName + '\'' +
                "limitCredit='" + userLimitCredit + '\'' +
                "risk='" + userRisk + '\'' +
                "interest='" + userInterest + '\'' +
                '}';
    }
}
