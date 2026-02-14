package File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
//        try ( FileInputStream  stream = new FileInputStream("test.txt")){
//            byte[] arr = new byte[stream.available()];
//            stream.skip(6);
//            System.out.println(stream.read(arr));
//            System.out.println(new String(arr));
//            System.out.println(stream.available());
//         int b;
//         while((b = stream.read()) !=-1){
//             System.out.print((char)b);
//            }
//        try(FileOutputStream stream = new FileOutputStream("test.txt")){
        try(FileInputStream in = new FileInputStream("test.txt");
            FileOutputStream out=new FileOutputStream("test2.txt")){
                byte[] bytes=new byte[in.available()];
                int tmp;
                while((tmp=in.read(bytes))!=-1){
                    out.write(bytes,0,tmp);
                }
//            stream.write("Hello World!".getBytes());
//            stream.flush();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
