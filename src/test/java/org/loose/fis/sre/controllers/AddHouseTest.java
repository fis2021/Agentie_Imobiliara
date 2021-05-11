

import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.HouseService;
import org.loose.fis.sre.model.House;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

 class AddHouseTest {
public static final String ADDRESS="Address";
 public static final String SIZE="Size";
 public static final String ROOMS="Rooms";
 public static final String BATHS="Baths";
 public static final String FLOORS="Floors";
 public static final String SPECIAL="Special";

   /*@BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
        System.out.println("Before each");
    }*/

  @AfterEach
  void tearDown() {
   System.out.println("After each");
  }

  @BeforeAll
  static void beforeAll() throws Exception{
   FileSystemService.APPLICATION_FOLDER = ".test-addhouses";
   FileSystemService.initDirectory_house();
   FileUtils.cleanDirectory(FileSystemService.getHouseHomeFolder().toFile());
   HouseService.initDatabase();
   System.out.println("Before class");
  }

  @AfterAll
  static void afterAll() {
   System.out.println("After class");
  }

  @Test
  @Order(1)
  @DisplayName("Database is initialized and there are no houses")
  void testDataBaseIsInitializedAndNoHousesIsPersisted() {
   assertThat(HouseService.getAllHouses()).isNotNull();
   assertThat(HouseService.getAllHouses()).isEmpty();
   System.out.println("1");
  }

  @Test
  @Order(2)
  @DisplayName("House is successfully persisted to Database")
  void testHouseIsAddedToDatabase() throws AddressAlreadyExistsException {
   HouseService.addHouse(ADDRESS, SIZE, ROOMS,BATHS,FLOORS, SPECIAL);
   assertThat(HouseService.getAllHouses()).isNotEmpty();
   assertThat(HouseService.getAllHouses()).size().isEqualTo(1);
   House house = HouseService.getAllHouses().get(0);
   assertThat(house).isNotNull();
   assertThat(house.getAddress()).isEqualTo(ADDRESS);
   //assertThat(house.getSize()).isEqualTo(SIZE);
   assertThat(house.getRooms()).isEqualTo(ROOMS);
   assertThat(house.getBaths()).isEqualTo(BATHS);
   assertThat(house.getFloors()).isEqualTo(FLOORS);
   assertThat(house.getSpecial()).isEqualTo(SPECIAL);
   System.out.println("2");
  }
  @Test
  @Order(3)
  @DisplayName("House can not be added twice")
  void testHouseCanNotBeAddedTwice() {
   assertThrows(AddressAlreadyExistsException.class, () -> {
    HouseService.addHouse(ADDRESS, SIZE, ROOMS,BATHS,FLOORS, SPECIAL);
    HouseService.addHouse(ADDRESS, SIZE, ROOMS,BATHS,FLOORS, SPECIAL);
   });
   System.out.println("3");
  }
  @Test
  @Order(4)
  @DisplayName("Address must be unique")
  void testAddressDoesNotAlreadyExist() {
   assertThrows(AddressAlreadyExistsException.class, () -> {
    HouseService.addHouse(ADDRESS, SIZE, ROOMS,BATHS,FLOORS, SPECIAL);
    HouseService.checkAddressDoesNotAlreadyExist(ADDRESS);
   });
   System.out.println("4");
  }
 /*
  @Test
  @Order(7)
  @DisplayName("Agent does exist")
  void testAgentDoesExist() {
   assertThrows(AgentDoesNotExistException.class, () -> {
    UserService.checkAgentDoesExist("agent");
   });
   System.out.println("7");
  }
  @Test
  @Order(8)
  @DisplayName("Username is correct")
  void testUsernameDoesExist() {
   assertThrows(IncorrectNameException.class, () -> {
    UserService.checkUsername("agent");
   });
   System.out.println("8");
  }
  @Test
  @Order(9)
  @DisplayName("Name is correct")
  void testNameDoesExist() {
   assertThrows(NoBookigsExectpion.class, () -> {
    UserService.CheckNameCredentials("agent");
   });
   System.out.println("9");
  }
  @Test
  @Order(10)
  @DisplayName("Agent list is correct")
  void testAgentList() throws UsernameAlreadyExistsException {
   assertThat(UserService.agents_lsit()).isEqualTo("fullName='Agent', phoneNumber='Agent'\n");
  }
 }*/
}
