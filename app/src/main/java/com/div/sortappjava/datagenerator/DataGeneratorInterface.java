package com.div.sortappjava.datagenerator;

import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;

/**
 * Created by arioch666 on 11/13/17.
 *
 * All data generators present and future should use implement this interface to allow for seamless
 * replacement of the Data Generator at any point without making any other changes.
 */

public interface DataGeneratorInterface {

    void generateData();

    Comparable[] getData();

}
