package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.AddressAlreadyExistsException;
import org.loose.fis.sre.model.House;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;
import static org.loose.fis.sre.services.FileSystemService.getPathToHouse;

public class HouseService {

    private static ObjectRepository<House> houseRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToHouse("house-database.db").toFile())
                .openOrCreate();
        houseRepository = database.getRepository(House.class);
    }
    public static ObjectRepository<House> getHouseRepository()
    {
        return houseRepository;
    }

    public static void addHouse(String Address,String Size,String Rooms, String Baths,String Floors, String Special) throws AddressAlreadyExistsException {
        checkAddressDoesNotAlreadyExist(Address);
        houseRepository.insert(new House(Address,Size,Rooms, Baths, Floors,Special));
    }

    private static void checkAddressDoesNotAlreadyExist(String address) throws AddressAlreadyExistsException {
        for (House house : houseRepository.find()) {
            if (Objects.equals(address, house.getAddress()))
                throw new AddressAlreadyExistsException(address);
        }
    }
}