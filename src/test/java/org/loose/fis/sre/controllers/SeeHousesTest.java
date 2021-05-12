

package org.loose.fis.sre.controllers;

import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.HouseService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;
@ExtendWith(ApplicationExtension.class)
class SeeHousesTest {
    public static final String ADDRESS = "Address";
    public static final String ADDRESS2 = "Address2";



    /*@BeforeAll
    static void beforeAll() throws Exception{
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
        System.out.println("Before Class");
    }*/
    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.HOUSE_FOLDER = ".test-see-deletehouse";
        FileSystemService.initDirectory_house();
        FileUtils.cleanDirectory(FileSystemService.getHouseHomeFolder().toFile());
        HouseService.initDatabase();
        HouseService.addHouse(ADDRESS,ADDRESS,ADDRESS,ADDRESS,ADDRESS,ADDRESS);
        HouseService.addHouse(ADDRESS2,ADDRESS2,ADDRESS2,ADDRESS2,ADDRESS2,ADDRESS2);


    }
    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("see_houses.fxml"));
        primaryStage.setTitle("Agentie Imobiliara");
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.show();
    }
    @Test
    void TestSeeHouse(FxRobot robot) {
        robot.clickOn("#seehouses");
        assertThat(robot.lookup("#title-text").queryText()).hasText(
                String.format("Address=Address, Size= Address, Rooms= Address, Baths= Address, Floors= Address, Special= Address\n" +
                        "Address=Address2, Size= Address2, Rooms= Address2, Baths= Address2, Floors= Address2, Special= Address2"));
        robot.clickOn("#searchButton");
        assertThat(robot.lookup("#deletehouseMessage").queryText()).hasText(
                String.format("Address=Address, Size= Address, Rooms= Address, Baths= Address, Floors= Address, Special= Address"));






    }
}
