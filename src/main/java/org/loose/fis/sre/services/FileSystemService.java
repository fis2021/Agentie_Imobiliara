package org.loose.fis.sre.services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String APPLICATION_FOLDER = ".agentie_imobiliara";
    private static final String HOUSE_FOLDER = ".house-database";
    private static final String USER_FOLDER = System.getProperty("user.home");
    public static final Path HOUSE_HOME_PATH = Paths.get(USER_FOLDER, HOUSE_FOLDER);
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
    public static Path getPathToHouse(String... path)
    {
        return HOUSE_HOME_PATH.resolve(Paths.get(".",path));
    }
}

