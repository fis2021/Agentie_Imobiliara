package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Booking {
    @Id
    private String hour;
    private String agent_book;
    private String special_req;
    public Booking(String hour, String agent_book, String special_req) {
        this.hour = hour;
        this.agent_book = agent_book;
        this.special_req = special_req;
    }
    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setAgent_book(String agent_book) {
        this.agent_book = agent_book;
    }

    public void setSpecial_req(String special_req) {
        this.special_req = special_req;
    }

    public String getHour() {
        return hour;
    }

    public String getAgent_book() {
        return agent_book;
    }

    public String getSpecial_req() {
        return special_req;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return hour.equals(booking.hour) && agent_book.equals(booking.agent_book) && special_req.equals(booking.special_req);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, agent_book, special_req);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "hour='" + hour + '\'' +
                ", agent_book='" + agent_book + '\'' +
                ", special_req='" + special_req + '\'' +
                '}';
    }
}