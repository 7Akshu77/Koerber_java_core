package q2;

import java.io.*;

public class NoBufferCopy {
        public void NoBufferc() throws FileNotFoundException, IOException {
            FileInputStream fis = new FileInputStream(new File("C:\\Users\\Akshaya.Sharavana\\Downloads\\download.jpg"));
            FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Akshaya.Sharavana\\Downloads\\download1.jpg"));
            int byteRead = 1;
            long start = System.currentTimeMillis();
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            fis.close();
            fos.close();
            long end = System.currentTimeMillis();
            System.out.println("The task is completed successfully without using buffer and the time taken is " + (end - start));
        }
}
