package org.elvin;

import org.elvin.utils.DatasetLoader;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.File;
import java.io.InputStream;
import java.util.Random;

public class NN {
    public static void main(String[] args) {
        String filepath = "/dataset.csv";
        try {
            InputStream inputStream = DatasetLoader.class.getResourceAsStream(filepath);

            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + filepath);
            }

            // Step 1: Load the dataset
            CSVLoader loader = new CSVLoader();
            loader.setSource(inputStream);
            Instances dataset = loader.getDataSet();


            dataset.setClassIndex(dataset.numAttributes() - 1);


            StringToWordVector filter = new StringToWordVector();
            filter.setInputFormat(dataset);
            Instances filteredData = Filter.useFilter(dataset, filter);


            MultilayerPerceptron neuralNetwork = new MultilayerPerceptron();
            neuralNetwork.setLearningRate(0.3);
            neuralNetwork.setMomentum(0.2);
            neuralNetwork.setTrainingTime(500);
            neuralNetwork.setHiddenLayers("a");


            int trainSize = (int) Math.round(filteredData.numInstances() * 0.1);
            int testSize = filteredData.numInstances() - trainSize;
            filteredData.randomize(new Random(42));
            Instances trainData = new Instances(filteredData, 0, trainSize);
            Instances testData = new Instances(filteredData, trainSize, testSize);

            // Step 6: Train the neural network model
            neuralNetwork.buildClassifier(trainData);

            // Step 7: Evaluate the model on the test set
            Evaluation evaluation = new Evaluation(trainData);
            evaluation.evaluateModel(neuralNetwork, testData);


            System.out.println("Results");
            System.out.println("======");
            System.out.println(evaluation.toSummaryString());
            System.out.println(evaluation.toClassDetailsString());
            System.out.println(evaluation.toMatrixString());


            String textToPredict = "Este é um exemplo de mensagem.";


            String preprocessedText = textToPredict.toLowerCase();
            Instances singleInstanceDataset = new Instances(filteredData, 0);
            double[] values = new double[singleInstanceDataset.numAttributes()];
            values[0] = singleInstanceDataset.attribute(0).addStringValue(preprocessedText); // Set the text attribute
            DenseInstance newInstance = new DenseInstance(1.0, values);
            newInstance.setDataset(singleInstanceDataset);


            Instances filteredSingleInstance = Filter.useFilter(singleInstanceDataset, filter);
            filteredSingleInstance.add(newInstance);


            double predictedClassIndex = neuralNetwork.classifyInstance(filteredSingleInstance.firstInstance());
            String predictedClassLabel = filteredData.classAttribute().value((int) predictedClassIndex);


            System.out.println("Predicted class: " + predictedClassLabel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
