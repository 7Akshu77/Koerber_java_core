import java.util.Arrays;
import java.util.Scanner;
public class Pascal {
 public static void main(String [] args){
  Scanner sc = new Scanner(System.in);
  System.out.println("enter the num of rows required");
  int n = sc.nextInt();
int mat[][] = new int[n][n];
for(int i=0;i<n;i++){
 for(int j=0;j<=i;j++){
  if((j==0) || i==j){
   mat[i][j] = 1;
  }
  else{
  mat[i][j] = mat[i-1][j-1]+mat[i-1][j];
  }
 }
}
System.out.println("the triangle is ");
for(int i=0;i<n;i++){
 for(int j=0;j<=i;j++){

  System.out.print(mat[i][j]+" ");
 }
System.out.println();
}

 }
}
