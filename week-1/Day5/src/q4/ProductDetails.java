package q4;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProductDetails {
    public static void main(String[] args){
        Queue<Product> pq = new PriorityQueue<>(new ProductPriceComparator());
        pq.offer(new Product(1,1000,"pen"));
        pq.offer(new Product(2,2000,"pencil"));
        pq.offer(new Product(3,5000,"eraser"));
        pq.offer(new Product(4,3000,"scale"));
        pq.offer(new Product(5,7000,"sharpner"));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

}
