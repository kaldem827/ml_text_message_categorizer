package org.elvin.utils;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.InputStream;
import java.util.ArrayList;

public class DatasetLoader {
    public static Instances loadDataset(String filepath) throws Exception {
        InputStream inputStream = DatasetLoader.class.getResourceAsStream(filepath);

        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: " + filepath);
        }

        CSVLoader loader = new CSVLoader();
        loader.setSource(inputStream);
        Instances dataset = loader.getDataSet();

        // Set class attribute (assuming the class attribute is the last one)
        dataset.setClassIndex(dataset.numAttributes() - 1);

        Instances featuredDataset = FeatureExtractor.extractFeatures(dataset);


        return featuredDataset;
    }

    public static Instances createEmptyDataset() throws Exception {
        // Define the attributes (replace these with your actual attributes)
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("text", (FastVector) null)); // Text attribute
        ArrayList<String> classValues = new ArrayList<>();
        classValues.add("spam");
        classValues.add("non-spam");
        attributes.add(new Attribute("class", classValues)); // Class attribute

        // Create a new empty dataset
        Instances dataset = new Instances("PredictionInstances", attributes, 0);
        dataset.setClassIndex(dataset.numAttributes() - 1);
        return dataset;
    }
}
