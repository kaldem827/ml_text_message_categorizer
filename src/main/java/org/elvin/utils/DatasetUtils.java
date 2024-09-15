package org.elvin.utils;

import weka.core.Instances;
import weka.core.Attribute;
import java.util.HashMap;
import java.util.Map;

public class DatasetUtils {
    public static Map<String, Integer> getClassValueCounts(Instances dataset) {
        // Ensure the class attribute is set
        if (dataset.classIndex() == -1) {
            throw new IllegalStateException("Class attribute not set in the dataset.");
        }

        // Get the class attribute
        Attribute classAttribute = dataset.classAttribute();

        // Map to store the counts of each class value
        Map<String, Integer> classCounts = new HashMap<>();

        // Initialize the map with all possible class values
        for (int i = 0; i < classAttribute.numValues(); i++) {
            classCounts.put(classAttribute.value(i), 0);
        }

        // Count the occurrences of each class value
        for (int i = 0; i < dataset.numInstances(); i++) {
            String classValue = dataset.instance(i).stringValue(classAttribute);
            classCounts.put(classValue, classCounts.get(classValue) + 1);
        }

        return classCounts;
    }
}
