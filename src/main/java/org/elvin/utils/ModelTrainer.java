package org.elvin.utils;

import weka.classifiers.Classifier;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

public class ModelTrainer {
    public static Classifier trainModel(Instances trainingData) throws Exception {
        SMO classifier = new SMO(); // Support Vector Machine
        classifier.buildClassifier(trainingData);
        return classifier;
    }
}
