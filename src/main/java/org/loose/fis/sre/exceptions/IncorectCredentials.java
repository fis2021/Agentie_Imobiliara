package org.loose.fis.sre.exceptions;

public class IncorectCredentials extends Exception {

    private String username;

    public IncorectCredentials(String username) {
        super(String.format("Incorrect username %s, password or role!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
