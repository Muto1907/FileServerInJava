package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String ADD = "add";
        final String GET = "get";
        final String DELETE = "delete";
        final String EXIT = "exit";
        final String ADD_SUCCESS = "The file %s added successfully%n";
        final String ADD_FAILURE = "Cannot add the file %s%n";
        final String GET_SUCCESS = "The file %s was sent%n";
        final String DELETE_SUCCCESS = "The file %s was deleted%n";
        final String FILE_NOT_FOUND = "The file %s was not found%n";
        FileServer server = new FileServer();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]){
                case ADD:
                    if (server.addFile(input[1])){
                        System.out.printf(ADD_SUCCESS, input[1]);
                    } else{
                        System.out.printf(ADD_FAILURE, input[1]);
                    }
                    break;
                case DELETE:
                    if(server.deleteFile(input[1])){
                        System.out.printf(DELETE_SUCCCESS, input[1]);
                    } else{
                        System.out.printf(FILE_NOT_FOUND, input[1]);
                    }
                    break;
                case GET:
                    if(server.getFile(input[1])){
                        System.out.printf(GET_SUCCESS, input[1]);
                    } else{
                        System.out.printf(FILE_NOT_FOUND, input[1]);
                    }
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Illegal Argument");
            }
        }

    }
}