package org.QaPracticalChallange.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

public class FileReaderWriteManager {

    private static FileReaderWriteManager fileReaderWriteManager = new FileReaderWriteManager();
    private static ConfigFileReader configFileReader;

    public FileReaderWriteManager() {
    }

    public static FileReaderWriteManager getInstance() {
        return fileReaderWriteManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public static String readFile(final String path) {
        try {
            return new String(Files.readAllBytes(toFile(path).toPath()));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not read: %s", path), e);
        }
    }

    private static File toFile(final String path) throws Exception {
        URL url = FileUtils.class.getResource("/" + path);
        if (url == null) {
            throw new RuntimeException(String.format("File not found: %s", path));
        }
        return new File(url.toURI());
    }
}
