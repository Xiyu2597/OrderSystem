package test3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
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
//        File file=new File("test");
//    System.out.println(file.createNewFile());创建文件
//       System.out.println(file.mkdir());创建目录
//      System.out.println(file.mkdirs());创建一系列
//        System.out.println(file.delete());
        File source = new File("source");
        for (File file : source.listFiles()) {
          copyFile(file,"target/"+file.getName());
        }
    }
    private static void copyFile(File file,String targetPath) {
        try (InputStream in = new FileInputStream(file);
            OutputStream out=new FileOutputStream(targetPath)){
            byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes,0,len);
        }
    }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
