import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
    //1. pure recursive code
    public static int rec_cvj(int des,int curr,int [] moves){
        //base case if it reaches end
           if(des==curr){
              return 1;
           }
           int maxstep=moves[curr];
           int ans=0;
           for(int step=1;step<=maxstep;step++){
               if(step+curr <= des)
               {ans+=rec_cvj(des, curr+step, moves);}
           }
           return ans;
    }
    //2.MEMOIZATION 
    public static int cvj_memo(int curr,int des,int [] moves,int [] mem){
        if(curr==des){
            mem[curr]=1;
            return 1;
        }
        int maxstep = moves[curr];
        int ans=0;
        if(mem[curr]!=-1){
            return mem[curr];
        }
        for(int step=1;step<=maxstep;step++){
            if(step+curr <=des){
            ans+=cvj_memo(curr+step, des, moves, mem);
            }
        }
        mem[curr]=ans;
        return ans;
    }
    //3 TABULATION
    public static int cvj_tab(int n,int [] moves,int []mem1) {
        mem1[n]=1;
        for(int i=n-1;i>=0;i--){
            int ans=0;
            int maxstep=moves[i];
            for(int step=1;step<=maxstep;step++){
                if(i+step<=n)
                {ans+=mem1[i+step];}
            }
            mem1[i]=ans;
        }
        return mem1[0];
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int moves []=new int [n];
        for(int i=0;i<n;i++){
            moves[i]=scn.nextInt();
        } 
        System.out.println(rec_cvj(n, 0, moves));
        int mem []=new int [n+1];
        for(int i=0;i<=n;i++){
            mem[i]=-1;
        }
        System.out.println(cvj_memo(0, n, moves, mem));
        //3. tabulation
        int mem1 []=new int [n+1];
        for(int i=0;i<=n;i++){
            mem1[i]=-1;
        }
        System.out.println(cvj_tab(n,moves,mem1));
        
    }
}



