package File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try ( FileInputStream  stream = new FileInputStream("test.txt")){
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
