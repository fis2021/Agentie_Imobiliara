package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Booking;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class BookingService {

    private static ObjectRepository<Booking> bookingRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("booking.db").toFile())
                .openOrCreate("agent_imb", "agent_imob");

        bookingRepository = database.getRepository(Booking.class);
    }
   /* public static void addBooking(String day,String hour,String agent_book,String special_req)
    {
        bookingepository.insert(new Booking(day,hour,agent_book,special_req));
    }*/
}