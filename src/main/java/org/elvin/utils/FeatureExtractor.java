package org.elvin.utils;
import weka.core.Instances;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class FeatureExtractor {
    public static Instances extractFeatures(Instances dataset) throws Exception {
        StringToWordVector filter = new StringToWordVector();
        filter.setAttributeIndices("first-last"); // Use all attributes
        filter.setTFTransform(true); // Apply TF
        filter.setIDFTransform(true); // Apply IDF
        filter.setTokenizer(new NGramTokenizer()); // Use N-Grams
        filter.setInputFormat(dataset);

        // Apply TF-IDF transformation  
        Instances newData = Filter.useFilter(dataset, filter);
        return newData;
    }
}
