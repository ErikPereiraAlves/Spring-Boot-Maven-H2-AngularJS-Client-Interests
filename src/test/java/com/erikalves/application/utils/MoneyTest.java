package com.erikalves.application.utils;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.Monetary;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.Locale;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryRounding;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

public class MoneyTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoneyTest.class);

    @Test
    public void testMoneyApi() {
        MonetaryAmount eurAmount1 = Monetary.getDefaultAmountFactory().setNumber(1.1111).setCurrency("REAL").create();
        MonetaryAmount eurAmount2 = Monetary.getDefaultAmountFactory().setNumber(1.1141).setCurrency("REAL").create();

        MonetaryAmount eurAmount3 = eurAmount1.add(eurAmount2);
        //assertThat(eurAmount3.toString(), is("EUR 2.2252"));

        LOGGER.debug(eurAmount3.toString());

        MonetaryRounding defaultRounding = Monetary.getDefaultRounding();
        MonetaryAmount eurAmount4 = eurAmount3.with(defaultRounding);
        //assertThat(eurAmount4.toString(), is("EUR 2.23"));

        MonetaryAmountFormat germanFormat = MonetaryFormats.getAmountFormat(Locale.US);
        //assertThat(germanFormat.format(eurAmount4), is("EUR 2,23") );


    }

}