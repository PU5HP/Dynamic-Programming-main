import java.io.*;
import java.util.*;

public class Main {
  public static int validBS_TABULATION(int n){
    int [][] mem = new int [2][n+1];
    //prefilled
    mem[0][0]=0;
    mem[1][0]=0;
    mem[0][1]=1;
    mem[1][1]=1;
    for(int col=2;col<=n;col++){
      mem[0][col]=mem[1][col-1];
      mem[1][col]=mem[0][col-1]+mem[1][col-1];
    }
    int ans =  mem[0][n]+mem[1][n];
    return ans;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the binary String:");
    int n = sc.nextInt();
    System.out.println("the number of valid binary strings are ::"+validBS_TABULATION(n));
  }
}
