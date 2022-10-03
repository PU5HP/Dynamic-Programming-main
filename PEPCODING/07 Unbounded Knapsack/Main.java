import java.io.*;

import java.util.*;

public class Main {

  public static int unbounded_Knapsack(int [] vals,int [] weights,int []mem,int n,int c){
    //move over the weights
    for(int i = 0;i<n;i++){
      //if(weights[i]<=mem.length())
      for(int j=weights[i];j<c+1;j++){
        if(mem[j]<vals[i]+mem[j-weights[i]]){
          mem[j]=vals[i]+mem[j-weights[i]];
        }
      }
    }
    return mem[c];
  }


  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of the weights:");
    int n = sc.nextInt();
    int [] vals = new int [n];
    System.out.println("Enter the vals array:");
    for(int i=0;i<n;i++){
       vals[i]=sc.nextInt();
    }
    int [] weights = new int [n];
    System.out.println("Enter the weights array:");
    for(int i=0;i<n;i++){
       weights[i]=sc.nextInt();
    }
    System.out.println("Enter the capacity of the bag:");
    int c = sc.nextInt();
    int [] mem = new int [c+1];
    System.out.println(unbounded_Knapsack(vals,weights,mem,n,c));
  }
}
