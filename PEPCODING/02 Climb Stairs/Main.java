//package 02 Climb Stairs;
import java.io.*;
import java.util.*;

public class Main {
   
    //pure recursive code 
    public static int rec_fuc(int n){
        if(n==0 || n==1){return 1;}
        if(n==2){return 2;}
        return rec_fuc(n-1)+rec_fuc(n-2)+rec_fuc(n-3);
    }
    
    //recursive code with memoisation 
    public static int rec_mem(int n,int [] mem) {
        if(n==0 || n==1){
            mem[n]=1;
        }
        if(n==2){
            mem[n]=2;
        }
        //check if already present in array
        if(mem[n]!=0){
            return mem[n];
        }
        int ans = rec_mem(n-1,mem)+rec_mem(n-2, mem)+rec_mem(n-3, mem);
        mem[n]=ans;
        return ans;
    }
    
    //ITERATION WITH TABULATION 
    public static int itr_mem(int n,int [] mem) {
        mem [0]=1; mem[1]=1; mem[2]=2;
        //check if already present in array
        for(int i=3;i<=n;i++){
            mem[i]=mem[i-1]+mem[i-2]+mem[i-3];
        }
        return mem[n];
    }
    
    //ITERATION WITH TABULATION optimization 
    public static int itr_mem_opt(int n) {
        int x=1; int y =1; int z=2;int ans=0;
        //check if already present in array
        for(int i=3;i<=n;i++){
            ans=x+y+z;
            x=y;
            y=z;
            z=ans;
        }
        return z;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(rec_fuc(n));
        int [] mem = new int [n+1];
        System.out.println(rec_mem(n, mem));
        System.out.println(itr_mem(n, mem));
        System.out.println(itr_mem_opt(n));
    }

}