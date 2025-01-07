import java.util.Arrays;
class arrcp{
 public static int[] copyOf(int[] arr){
  return Arrays.copyOf(arr, arr.length);
 }
}
public class Copy {
 public static void main(String []agrs){
int array[] = {1,53,25,2,67,9};
int copy_arr[] = arrcp.copyOf(array);
System.out.println(Arrays.toString(copy_arr));
 }
}
