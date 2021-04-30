package org.loose.fis.sre.services;
import org.loose.fis.sre.services.HouseService;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Booking;
import org.loose.fis.sre.model.House;
import org.loose.fis.sre.exceptions.BookingAlreadyExistsException;
import org.loose.fis.sre.exceptions.HouseDoesNotExistsException;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToBooking;

public class BookingService {

    private static ObjectRepository<Booking> bookingRepository;
    //private static ObjectRepository<House> houseRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToBooking("booking-database.db").toFile())
                .openOrCreate("agent_imb", "agent_imob");

        bookingRepository = database.getRepository(Booking.class);
    }
    public static ObjectRepository<Booking> getBookingRepository()
    {
        return bookingRepository;
    }
    public static void addBooking(String address,String day,String hour, String agent_book, String special_req,String user) throws BookingAlreadyExistsException//, HouseDoesNotExistsException
    {
        checkBookingDoesNotAlreadyExist(day,hour,agent_book);
        //checkAddressDoesNotAlreadyExist(address);
        bookingRepository.insert(new Booking(address,day,hour,agent_book,special_req,user));
    }

    private static void checkBookingDoesNotAlreadyExist(String day,String hour,String agent_book) throws BookingAlreadyExistsException {
        for (Booking booking : bookingRepository.find()) {
            if (Objects.equals(day, booking.getDay()) && Objects.equals(hour, booking.getHour()) && Objects.equals(agent_book, booking.getAgent_book()))
                throw new BookingAlreadyExistsException(day,hour,agent_book);
        }
    }
    /*private static void checkAddressDoesNotAlreadyExist(String address) throws HouseDoesNotExistsException {
        for (House house : houseRepository.find()) {
            if (Objects.equals(address, house.getAddress()))
                return;
            throw new HouseDoesNotExistsException(address);
        }
    }*/
}