
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//1. get all the link to be downloaded...
    class FileUtil{
        //give u list of all vidoes/file
        public static List<String> readFiles(String fileName){
            List<String> files=new ArrayList<>();

            try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
                String line=null;
                while ((line=br.readLine())!=null){
                    files.add(line);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return files;
        }
    }
    //2 .create filedownloader
    class DownloadManager{
        public static void download(String url){
            System.out.println(Thread.currentThread().getName()+" is starting download "+ url);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" is done download "+ url);
        }
    }
   class download implements Runnable{
        String url;
        public void run(){
            DownloadManager.download(url);
        }
   }

    public class FileDownloader {
        public static void main(String[] args){
            List<String> urls=FileUtil.readFiles("C:\\Koerber_java_core\\week-2\\q1\\link.txt");
            List<Thread> th = new ArrayList<>();
            long start = System.currentTimeMillis();
            for(String url: urls) {

                    Thread t = new Thread(new download(), url);
                    th.add(t);
                    t.start();

            }
            long end = System.currentTimeMillis();
            System.out.println("The task is completed successfully and the time taken is " + (end - start));
        }
    }

