package com.div.sortappjava.datagenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static com.div.sortappjava.utils.Constants.DataGenerator.ASCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.DESCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;

/**
 * Created by arioch666 on 11/13/17.
 */

public class IntegerDataGeneratorSingleton implements DataGeneratorInterface {

    private int size = 50;
    private int initializationType = RANDOM;

    private Comparable[] values;

    private static final IntegerDataGeneratorSingleton ourInstance = new IntegerDataGeneratorSingleton();

    public static IntegerDataGeneratorSingleton getInstance() {
        return ourInstance;
    }

    private IntegerDataGeneratorSingleton() {
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setInitializationType(int initializationType) {
        this.initializationType = initializationType;
    }


    @Override
    public void generateData() {
        switch (initializationType) {
            case RANDOM:
                generateRandomData();
                break;
            case ASCENDING:
                generateAscendingData();
                break;
            case DESCENDING:
                generateDescendingData();
                break;
        }
    }

    @Override
    public Comparable[] getData() {
        if (values == null) {
            generateData();
        }

        return values;
    }

    private void generateDescendingData() {
        generateRandomData();
        Arrays.sort(values, (comparable, other) -> other.compareTo(comparable));
    }

    private void generateAscendingData() {
        generateRandomData();
        Arrays.sort(values, (comparable, other) -> comparable.compareTo(other));
    }

    private void generateRandomData() {
        Random random = new Random();

        int i = 0;
        values = new Comparable[size];
        while(i < size) {
            values[i++] = random.nextInt(Math.min(size*2, Integer.MAX_VALUE));
        }

    }
}
