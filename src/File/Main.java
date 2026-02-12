package File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try ( FileInputStream  stream = new FileInputStream("test.txt")){
            byte[] arr = new byte[stream.available()];
            stream.skip(6);
            System.out.println(stream.read(arr));
            System.out.println(new String(arr));
//            System.out.println(stream.available());
//         int b;
//         while((b = stream.read()) !=-1){
//             System.out.print((char)b);
//            }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
