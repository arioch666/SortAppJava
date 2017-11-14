package com.div.sortappjava.datagenerator;

import java.util.Arrays;
import java.util.Random;

import static com.div.sortappjava.utils.Constants.DataGenerator.ASCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.DESCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;

/**
 * Created by arioch666 on 11/13/17.
 *
 * Generates integer data based on the conditions specified using the {@link IntegerDataGeneratorSingleton#size}
 * and {@link IntegerDataGeneratorSingleton#initializationType} the values for the initialization
 * type can be any of {@link com.div.sortappjava.utils.Constants.DataGenerator} values.
 *
 */
public class IntegerDataGeneratorSingleton implements DataGeneratorInterface {

    //Size of the array
    private int size = 50;

    //The way the data should be initialized.
    private int initializationType = RANDOM;

    Comparable[] values;

    private static final IntegerDataGeneratorSingleton ourInstance = new IntegerDataGeneratorSingleton();

    public static IntegerDataGeneratorSingleton getInstance() {
        return ourInstance;
    }

    private IntegerDataGeneratorSingleton() {
    }

    /**
     *
     * @param size is the size of the data set generated.
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void setInitializationType(int initializationType) {
        this.initializationType = initializationType;
    }


    /**
     * comes from the interface {@link DataGeneratorInterface}
     */
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

    /**
     * comes from the interface {@link DataGeneratorInterface}
     */
    @Override
    public Comparable[] getData() {
        if (values == null) {
            generateData();
        }

        return values;
    }

    /**
     * Helper method to generate data and then sort it in descending order.
     */
    private void generateDescendingData() {
        generateRandomData();
        Arrays.sort(values, (comparable, other) -> other.compareTo(comparable));
    }

    /**
     * Helper method to generate data and then sort it in descending order.
     */
    private void generateAscendingData() {
        generateRandomData();
        Arrays.sort(values, (comparable, other) -> comparable.compareTo(other));
    }

    /**
     * Actually generates the data and is used internally in the
     * {@link IntegerDataGeneratorSingleton#generateAscendingData} and
     * {@link IntegerDataGeneratorSingleton#generateDescendingData()} methods in order to actually
     * build the data and then it gets sorted in the necessary ordering.
     *
     * uses the size to determine the number we use.
     */
    private void generateRandomData() {
        Random random = new Random();

        int i = 0;
        values = new Comparable[size];
        while(i < size) {
            values[i++] = random.nextInt(size*2);
        }
    }

}
