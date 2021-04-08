package exceptions;

public class UserNameAlreadyExistsException extends Exception{
        private String username;

        public UserNameAlreadyExistsException(String username) {
            super(String.format("An account with the username %s already exists!", username));
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

