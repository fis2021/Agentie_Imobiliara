package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Booking {


    @Id
    private String address;
    private String day;
    private String hour;
    private String agent_book;
    private String special_req;
    private String accept_booking;
    private String rejection_message;

    public Booking(String address,String day,String hour, String agent_book, String special_req) {
        this.address = address;
        this.day = day;
        this.hour = hour;
        this.agent_book = agent_book;
        this.special_req = special_req;
        this.accept_booking="rejected";
        this.rejection_message=" ";
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getAccept_booking() {
        return accept_booking;
    }

    public void setAccept_booking(String accept_booking) {
        this.accept_booking = accept_booking;
    }

    public String getRejection_message() {
        return rejection_message;
    }

    public void setRejection_message(String rejection_message) {
        this.rejection_message = rejection_message;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Booking booking = (Booking) object;
        return address.equals(booking.address) && day.equals(booking.day) && hour.equals(booking.hour) && agent_book.equals(booking.agent_book) && special_req.equals(booking.special_req) && accept_booking.equals(booking.accept_booking) && rejection_message.equals(booking.rejection_message);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), address, day, hour, agent_book, special_req, accept_booking, rejection_message);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Booking{" +
                "address='" + address + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", agent_book='" + agent_book + '\'' +
                ", special_req='" + special_req + '\'' +
                ", accept_booking='" + accept_booking + '\'' +
                ", rejection_message='" + rejection_message + '\'' +
                '}';
    }
}