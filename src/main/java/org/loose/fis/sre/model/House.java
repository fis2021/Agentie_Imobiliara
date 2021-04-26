package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class House {
    @Id
    private String Adresa;
    private Integer Size;
    private Integer Rooms;
    private Integer Baths;
    private Integer Floors;
    private String Special;

    public House(String adresa, Integer size, Integer rooms, Integer baths, Integer floors, String special) {
        Adresa = adresa;
        Size = size;
        Rooms = rooms;
        Baths = baths;
        Floors = floors;
        Special = special;
    }

    public String getAdresa() {
        return Adresa;
    }

    public Integer getRooms() {
        return Rooms;
    }

    public Integer getBaths() {
        return Baths;
    }

    public Integer getFloors() {
        return Floors;
    }

    public String getSpecial() {
        return Special;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public void setRooms(Integer rooms) {
        Rooms = rooms;
    }

    public void setBaths(Integer baths) {
        Baths = baths;
    }

    public void setFloors(Integer floors) {
        Floors = floors;
    }

    public void setSpecial(String special) {
        Special = special;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(Adresa, house.Adresa) && Objects.equals(Size, house.Size) && Objects.equals(Rooms, house.Rooms) && Objects.equals(Baths, house.Baths) && Objects.equals(Floors, house.Floors) && Objects.equals(Special, house.Special);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Adresa, Size, Rooms, Baths, Floors, Special);
    }

    @Override
    public String toString() {
        return "House{" +
                "Adresa='" + Adresa + '\'' +
                ", Size=" + Size +
                ", Rooms=" + Rooms +
                ", Baths=" + Baths +
                ", Floors=" + Floors +
                ", Special='" + Special + '\'' +
                '}';
    }
}
