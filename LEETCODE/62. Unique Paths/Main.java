import java.util.Scanner;
public class Main {
    
    public static int UNIQUEPATHS(int dr,int dc,int[][] mem) {
        //filling the last bloack of the mem matrix with last value
        mem[dr][dc] = 1;
        int paths=0;
        for(int i=dr;i>=0;i--){
            for(int j=dc;j>=0;j--){
                //skip the last block
                if(j+1>dc && i+1>dr ){
                   continue;
                }
                else if(j+1<=dc && i+1>dr){
                    //last row
                    mem[i][j] = mem[i][j]+mem[i][j+1];
                }
                else if(j+1<=dc && i+1<=dr){
                    //some middle box
                    mem[i][j] = mem[i][j]+ (mem[i][j+1]+mem[i+1][j]);
                }
                else if(j+1>dc && i+1<=dr){
                    //last col
                    mem[i][j] = mem[i][j]+mem[i+1][j];
                }
                else{
                    continue;
                }
            }
        }
        return mem[0][0];
    }
    


    public static void main(String[] args) {
        //taking input for the matrix
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of rows:");
        int r = sc.nextInt();
        System.out.println("enter no of cols:");
        int c = sc.nextInt();
        //creating input matrix
       // System.out.println("enter your matrix:");
        int [][] inpmat = new int [r][c];
        //displaying the input matrix
        System.out.println("input matrix:");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               System.out.print( inpmat[i][j] +" " );
            }
            System.out.println();
        }
        //creating extra memory for the tabulation
        int [][] mem = new int [r][c];
        System.out.println(UNIQUEPATHS(r-1,c-1,mem));
        
        System.out.println("memory matrix:");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               System.out.print( mem[i][j] +" " );
            }
            System.out.println();
        }
    }
}
