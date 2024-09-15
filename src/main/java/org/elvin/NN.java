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
            loader.setSource(inputStream);  // Adjust the path to your dataset
            Instances dataset = loader.getDataSet();

            // Step 2: Set the class attribute (last column in this case)
            dataset.setClassIndex(dataset.numAttributes() - 1);

            // Step 3: Apply StringToWordVector filter to convert text to vector form
            StringToWordVector filter = new StringToWordVector();
            filter.setInputFormat(dataset);
            Instances filteredData = Filter.useFilter(dataset, filter);

            // Step 4: Initialize and configure the neural network model
            MultilayerPerceptron neuralNetwork = new MultilayerPerceptron();
            neuralNetwork.setLearningRate(0.3);
            neuralNetwork.setMomentum(0.2);
            neuralNetwork.setTrainingTime(500);
            neuralNetwork.setHiddenLayers("a");

            // Step 5: Split the dataset into training and test sets (80% train, 20% test)
            int trainSize = (int) Math.round(filteredData.numInstances() * 0.8);
            int testSize = filteredData.numInstances() - trainSize;
            filteredData.randomize(new Random(42));
            Instances trainData = new Instances(filteredData, 0, trainSize);
            Instances testData = new Instances(filteredData, trainSize, testSize);

            // Step 6: Train the neural network model
            neuralNetwork.buildClassifier(trainData);

            // Step 7: Evaluate the model on the test set
            Evaluation evaluation = new Evaluation(trainData);
            evaluation.evaluateModel(neuralNetwork, testData);

            // Output the evaluation results
            System.out.println("Results");
            System.out.println("======");
            System.out.println(evaluation.toSummaryString());
            System.out.println(evaluation.toClassDetailsString());
            System.out.println(evaluation.toMatrixString());

            // Step 8: Make a prediction with a single instance
            String textToPredict = "Este é um exemplo de mensagem.";  // Replace with your own text

            // Preprocess the input text (lowercase and apply StringToWordVector)
            String preprocessedText = textToPredict.toLowerCase(); // Simplified preprocessing
            Instances singleInstanceDataset = new Instances(filteredData, 0);  // Empty dataset with the structure
            double[] values = new double[singleInstanceDataset.numAttributes()];
            values[0] = singleInstanceDataset.attribute(0).addStringValue(preprocessedText); // Set the text attribute
            DenseInstance newInstance = new DenseInstance(1.0, values);
            newInstance.setDataset(singleInstanceDataset);

            // Apply the StringToWordVector filter to the single instance
            Instances filteredSingleInstance = Filter.useFilter(singleInstanceDataset, filter);
            filteredSingleInstance.add(newInstance);

            // Predict the class
            double predictedClassIndex = neuralNetwork.classifyInstance(filteredSingleInstance.firstInstance());
            String predictedClassLabel = filteredData.classAttribute().value((int) predictedClassIndex);

            // Output the prediction
            System.out.println("Predicted class: " + predictedClassLabel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
