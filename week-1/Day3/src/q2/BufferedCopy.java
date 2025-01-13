package q2;

import java.io.*;

public class BufferedCopy {
    public void Bufferc() throws FileNotFoundException, IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Akshaya.Sharavana\\Downloads\\download.jpg")));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Akshaya.Sharavana\\Downloads\\download1.jpg")));
        long start = System.currentTimeMillis();
        int byteRead = 1;
        while ((byteRead = fis.read()) != -1) {
            fos.write(byteRead);
        }
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println("The task is completed successfully using buffer and the time taken is "+(end-start));
    }
}
