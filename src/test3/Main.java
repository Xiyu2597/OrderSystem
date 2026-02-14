package test3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        try(FileReader reader=new FileReader("test.txt")){
//            char[] str=new char[10];
//            reader.read(str);
//            System.out.println(new String(str));
//        try(FileWriter writer=new FileWriter("test.txt")){
//           writer.write("随便");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        File file=new File("test.txt");
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        System.out.println(file.isHidden());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(file.canExecute());
//        try(FileWriter writer=new FileWriter(file)){
//             writer.write("Hello World");
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
        File file=new File("test");
//        System.out.println(file.createNewFile());创建文件
//        System.out.println(file.mkdir());创建目录
//        System.out.println(file.mkdirs());创建一系列
        System.out.println(file.delete());
    }
}
