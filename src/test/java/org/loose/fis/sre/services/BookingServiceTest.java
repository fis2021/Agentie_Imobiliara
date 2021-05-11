package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.model.Booking;
import org.loose.fis.sre.model.User;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;

import static org.assertj.core.api.InstanceOfAssertFactories.BYTE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceTest {
    public static final String ADMIN = "admin";
    public static final String AGENT = "Agent";
/*@BeforeEach
    void setUp() throws Exception {
        FileSystemService.BOOKING_FOLDER = ".test-booking";
        FileSystemService.initDirectory_booking();
        FileUtils.cleanDirectory(FileSystemService.getBookingHomeFolder().toFile());
        BookingService.initDatabase();
        System.out.println("Before each");
    }*/

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @BeforeAll
    static void beforeAll() throws Exception {
        FileSystemService.BOOKING_FOLDER = ".test-booking";
        FileSystemService.initDirectory_booking();
        FileUtils.cleanDirectory(FileSystemService.getBookingHomeFolder().toFile());
        BookingService.initDatabase();

        FileSystemService.APPLICATION_FOLDER = ".test-registration-forbooking";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
        System.out.println("Before class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After class");
    }

    @Test
    @Order(1)
    @DisplayName("Database is initialized and there are no bookings")
    void testDataBaseIsInitializedAndNoBookingIsPersisted() {
        assertThat(BookingService.getAllBookings()).isNotNull();
        assertThat(BookingService.getAllBookings()).isEmpty();
        System.out.println("1");
    }

    @Test
    @Order(2)
    @DisplayName("Booking can not be added for an agent that does not exist")
    void testBookingForWrongAgent() {
        assertThrows(AgentDoesNotExistException.class, () -> {
            BookingService.addBooking(ADMIN, ADMIN, ADMIN, ADMIN, ADMIN, ADMIN, ADMIN, ADMIN);
        });
        System.out.println("2");
    }

    @Test
    @Order(3)
    @DisplayName("Booking can not be added for a name that does not exist")
    void testBookingForWrongName() {
        assertThrows(IncorrectNameException.class, () -> {
            UserService.addUser(AGENT, AGENT, AGENT, AGENT, AGENT);
            BookingService.addBooking(ADMIN, ADMIN, ADMIN, ADMIN, ADMIN, AGENT, ADMIN, ADMIN);
        });
        System.out.println("3");
    }

    @Test
    @Order(8)
    @DisplayName("Booking list is corect")
    void testSeeBookings() throws NoBookigsExectpion {
        assertThat(BookingService.seeBookings(AGENT)).isEqualTo("Booking{address= Admin, day=Admin, year= Admin, hour= Admin, agent_book= Admin, special_req= Admin, accept_booking= Admin, rejection_message= Admin,, Name='Admin}\n");
        System.out.println("8");
    }
    @Test
    @Order(9)
    @DisplayName("Booking list is empty")
    void testSeeBookingsEmpty()  {
    assertThrows(NoBookigsExectpion.class, () -> {
        BookingService.seeBookings();
    }
    );
        System.out.println("9");
    }
}