package org.example;


public class Main {
    public static void main(String[] args) {
        final String ADD = "add";
        final String GET = "get";
        final String DELETE = "delete";
        final String EXIT = "exit";
        final String ADD_SUCCESS = "The file %s added successfully%n";
        final String ADD_FAILURE = "Cannot add the file %s";
        final String GET_SUCCESS = "The file %s was sent%n";
        final String DELETE_SUCCCESS = "The file %s was deleted%n";
        final String FILE_NOT_FOUND = "The file %s was not found%n";
        FileServer server = new FileServer();
    }
}