package org.elvin.utils;

import weka.core.SerializationHelper;
import java.io.InputStream;

public class ModelLoader {

    // Method to load the model
    public static Object loadModel(String fileName) throws Exception {
        // Load the model from the resources folder
        try (InputStream inputStream = ModelLoader.class.getResourceAsStream("/" + fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + fileName);
            }
            // Use Weka's SerializationHelper to read the model from the input stream
            return SerializationHelper.read(inputStream);
        }
    }
}
