package com.div.sortappjava;

import com.div.sortappjava.datagenerator.datagenerators.IntegerDataGeneratorSingleton;

import org.junit.Before;
import org.junit.Test;

import static com.div.sortappjava.utils.Constants.ComparableConstants.GREATER;
import static com.div.sortappjava.utils.Constants.ComparableConstants.LESS;
import static com.div.sortappjava.utils.Constants.DataGenerator.ASCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.DESCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by arioch666 on 11/13/17.
 */

public class DataGeneratorTest {

    private IntegerDataGeneratorSingleton<Integer> integerDataGeneratorSingleton;
    private Comparable[] data;

    @Before
    public void setup() {
        this.integerDataGeneratorSingleton = IntegerDataGeneratorSingleton.getInstance();
        integerDataGeneratorSingleton.setSize(15);
    }

    @Test
    public void testRandomData() {

        generateData(RANDOM);

        assertTrue(true);
    }


    @Test
    public void testAscendingData() {
        generateData(ASCENDING);


        for (int i = 0; i < data.length-1;i++) {
            switch (data[i].compareTo(data[i+1])) {
                case GREATER:
                    fail("not in Ascending order");
            }
        }

        assertTrue(true);
    }

    @Test
    public void testDescendingData() {
        generateData(DESCENDING);

        for (int i = 0; i < data.length-1;i++) {
            switch (data[i].compareTo(data[i+1])) {
                case LESS:
                fail("not in descending order");
            }
        }

        assertTrue(true);
    }


    private void generateData(int type) {
        integerDataGeneratorSingleton.setInitializationType(type);

        integerDataGeneratorSingleton.generateData();

        data = integerDataGeneratorSingleton.getData();

        assertTrue(data.length ==15);

        for (Comparable dataItem : data) {
            if (dataItem == null) {
                fail("Not all values generated");
            }
        }
    }



}
