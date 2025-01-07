import java.util.Scanner;
public class Grades {
 public static void main(String [] args){
  Scanner sc = new Scanner(System.in);
  int numStudents=0;
  int marks;
  System.out.println("enter the number of students");
  numStudents = sc.nextInt();
  int cnt=0;
int grad[]=new int[numStudents];
while(cnt<numStudents){
 System.out.println("Enter the grades for student"+(cnt+1)+": ");
 int gr = sc.nextInt();
 if(gr>100 || gr<0){
  System.out.println("Invalid.Please re-enter");
  continue;
 }
 grad[cnt++] = gr;
}
int tot=0;
for(int g:grad)
{
tot+=g;
} 
System.out.println("total marks: "+ tot);
float avg = tot/cnt;
System.out.println("Average is: "+ avg);
}
}
