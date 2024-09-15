package org.elvin.utils;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.classifiers.Evaluation;
import java.util.Random;

public class ModelEvaluator {
    public static void evaluateModel(Classifier model, Instances data) throws Exception {
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(model, data, 10, new Random(1));

        System.out.println(evaluation.toSummaryString("\nResults\n======\n", false));
        System.out.println(evaluation.toClassDetailsString());
        System.out.println(evaluation.toMatrixString());
    }
}
