package org.elvin.utils;

import weka.core.SerializationHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class ModelSaver {

    // Method to save the model
    public static void saveModel(Object model, String fileName) throws Exception {
        // Construct the file path to the resources directory
        String resourcesPath = Paths.get("src", "main", "resources", fileName).toString();

        // Create the file output stream
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(resourcesPath))) {
            // Use Weka's SerializationHelper to write the model
            SerializationHelper.write(fileOutputStream, model);
        }
    }
}
