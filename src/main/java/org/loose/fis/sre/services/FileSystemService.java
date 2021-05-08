package org.loose.fis.sre.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    //user
    public static String APPLICATION_FOLDER = ".agentie_imobiliara";

    private static final String HOUSE_FOLDER = ".house-database";
    private static final String BOOKING_FOLDER = ".booking-database";
    //user
    private static final String USER_FOLDER = System.getProperty("user.home");

    public static final Path HOUSE_HOME_PATH = Paths.get(USER_FOLDER, HOUSE_FOLDER);
    //user
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    public static final Path BOOKING_HOME_PATH = Paths.get(USER_FOLDER, BOOKING_FOLDER);
    //user
    public static Path getPathToFile(String... path){ return getApplicationHomeFolder().resolve(Paths.get(".", path));
    }

    public static Path getPathToHouse(String... path)
    {
        return HOUSE_HOME_PATH.resolve(Paths.get(".",path));
    }
    public static Path getPathToBooking(String... path)
    {
        return BOOKING_HOME_PATH.resolve(Paths.get(".",path));
    }

    //user
    public static Path getApplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    public static void initDirectory() {
        Path applicationHomePath = getApplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

}

