package org.elvin.utils;

import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class Predictor {

    public static String predictSingleInstance(Classifier model, String text, Instances datasetStructure) throws Exception {
        // Preprocess the text (you should call your preprocessing method here)
        String preprocessedText = TextPreprocessor.preprocess(text);

        // Create a new instance
        double[] values = new double[datasetStructure.numAttributes()];
        values[0] = datasetStructure.attribute(0).addStringValue(preprocessedText); // Set the text attribute
        // Class attribute is not set since we are predicting it
        Instance newInstance = new DenseInstance(1.0, values);
        newInstance.setDataset(datasetStructure); // Set the dataset structure


        // Predict the class
        double predictedClassIndex = model.classifyInstance(newInstance);
        String predictedClassLabel = datasetStructure.classAttribute().value((int) predictedClassIndex);

        return predictedClassLabel;
    }
}
