package org.example;


public class FileServer {
    private boolean[] files;
    final static int ERR = -1;
    final static int DEFAULT_SIZE = 10;


    public FileServer(){
        this.files = new boolean[DEFAULT_SIZE];
    }

    public FileServer(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be > 0");
        }
            this.files = new boolean[size];

    }

    public boolean addFile(String fileName){
        if (fileName == null){
            return false;
        }
        int i = parseFileName(fileName);
        if (i >= this.files.length || i < 0 || this.contains(i)){
            return false;
        }
        this.files[i] = true;
        return true;
    }

    public boolean getFile(String fileName){
        if (fileName == null){
            return false;
        }
        int i = parseFileName(fileName);
        if (i >= this.files.length || i < 0){
            return false;
        }
        return this.files[i];
    }

    public boolean deleteFile(String fileName){
        if (fileName == null){
            return false;
        }
        int i = parseFileName(fileName);
        if (i >= this.files.length || i < 0 || !this.contains(i)){
            return false;
        }
        this.files[i] = false;
        return true;
    }

    private int parseFileName(String fileName){
        if (!fileName.matches("^file([1-9]|10)$")){
            return ERR;
        }
        return Integer.parseInt(fileName.split("e")[1]) - 1;

    }

    private boolean contains(int i){
        return this.files[i];
    }
}
