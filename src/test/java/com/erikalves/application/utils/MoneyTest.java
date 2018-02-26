package com.erikalves.application.utils;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryRounding;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

// Nao utilizado na aplicacao. Apenas mostrando uma 2nd opcao que se poderia utilizar. Erik Pereira Alves
public class MoneyTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoneyTest.class);

    @Test
    public void testMoneyApi() {
        MonetaryAmount money1 = Monetary.getDefaultAmountFactory().setNumber(1.1111).setCurrency("BRL").create();
        MonetaryAmount money2 = Monetary.getDefaultAmountFactory().setNumber(1.1141).setCurrency("BRL").create();

        MonetaryAmount money3 = money1.add(money2);
        assertThat(money3.toString(), is("BRL 2.2252"));

        LOGGER.debug(money3.toString());

        MonetaryRounding defaultRounding = Monetary.getDefaultRounding();
        MonetaryAmount money4 = money3.with(defaultRounding);
        assertThat(money4.toString(), is("BRL 2.23"));



    }

}