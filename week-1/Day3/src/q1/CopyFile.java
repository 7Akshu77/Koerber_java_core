package q1;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Akshaya.Sharavana\\Downloads\\download.jpg"));
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Akshaya.Sharavana\\Downloads\\download1.jpg"));
        int byteRead = 1;
        while ((byteRead = fis.read()) != -1) {
            fos.write(byteRead);
        }
        fis.close();
        fos.close();
        System.out.println("The task is completed successfully");
    }
}