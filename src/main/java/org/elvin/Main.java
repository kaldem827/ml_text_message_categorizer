package org.elvin;

import org.elvin.utils.*;
import weka.core.Instances;
import weka.classifiers.Classifier;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Instances dataset = DatasetLoader.loadDataset("/dataset.csv");

        train(dataset);
    }
    public static void train(Instances dataset){
        try {
            // Load and preprocess dataset

            Map<String, Integer> classCounts = DatasetUtils.getClassValueCounts(dataset);

            System.out.println("Class value counts: " + classCounts);
            Constants.Pair<Instances, Instances> data =  DatasetProcessor.shuffleAndSplitDataset(dataset);
            // Train model
            Classifier model = ModelTrainer.trainModel(data.getFirst());

            // Evaluate model
            ModelEvaluator.evaluateModel(model, data.getSecond());

            ModelSaver.saveModel(model, "model.model");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void predict() throws Exception {
        Classifier model = (Classifier) ModelLoader.loadModel("model.model");

        // Load the saved model

        // Create the dataset structure
        Instances datasetStructure = DatasetLoader.createEmptyDataset();

        // Text to predict
        String textToPredict = "Ola tudo bem?.";

        // Predict the class
        String predictedClass = Predictor.predictSingleInstance(model, textToPredict, datasetStructure);

        // Output the prediction
        System.out.println("Predicted class: " + predictedClass);
    }
}
