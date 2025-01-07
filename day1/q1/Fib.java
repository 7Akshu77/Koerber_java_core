import java.util.Scanner;
public class Fib {
public static void main(String []args){
Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
int sum=0;
int cur=1;
int next =1;
int cnt=0;
while(cnt<20){
System.out.println(cur+" ");
sum+=cur;
int temp = cur+next;
cur = next;
next = temp;
cnt++;
}
float avg = sum/cnt;
System.out.println("The avg is: "+ avg);
} 
}
