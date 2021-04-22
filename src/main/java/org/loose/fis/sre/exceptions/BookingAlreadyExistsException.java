package org.loose.fis.sre.exceptions;

public class BookingAlreadyExistsException extends Exception {

    private String day;
    private String hour;
    private String agent_book;

    public BookingAlreadyExistsException(String day,String hour,String agent_book) {
        super(String.format("A booking %s at %s with the agent %s already exists!", day,hour,agent_book));
        this.day = day;
        this.hour = hour;
        this.agent_book = agent_book;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getAgent_book() {
        return agent_book;
    }
}
