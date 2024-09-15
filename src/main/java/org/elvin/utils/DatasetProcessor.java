package org.elvin.utils;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.Randomize;

public class DatasetProcessor {
    public static Constants.Pair<Instances, Instances> shuffleAndSplitDataset(Instances dataset) throws Exception {
        // Load the dataset

        // Shuffle the dataset
        Randomize randomize = new Randomize();
        randomize.setInputFormat(dataset);
        randomize.setRandomSeed(42); // Set seed for reproducibility
        Instances shuffledData = Filter.useFilter(dataset, randomize);

        // Split the data into training and testing sets
        int trainSize = (int) Math.round(shuffledData.numInstances() * .8);
        int testSize = shuffledData.numInstances() - trainSize;

        Instances trainData = new Instances(shuffledData, 0, trainSize);
        Instances testData = new Instances(shuffledData, trainSize, testSize);

        // Return the train and test data as a Pair
        return new Constants.Pair<>(trainData, testData);
    }

}
