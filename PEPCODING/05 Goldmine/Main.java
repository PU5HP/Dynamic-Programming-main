import java.util.Scanner;
public class Main {

    public static int goldmine(int[][] mem,int [][] inpmat) {
        //filling the last bloack of the mem matrix with last value
        int c=inpmat[0].length;
        int r=inpmat.length;
        for(int col=c-1;col>=0;col--){
            for(int row=r-1;row>=0;row--){
                if(col==c-1){
                    mem[row][col]=inpmat[row][col];
                }
                else if(row==r-1){
                    mem[row][col]=Math.max(mem[row][col+1], mem[row-1][col+1]) + inpmat[row][col];
                }
                else if(row==0){
                    mem[row][col]=Math.max(mem[row][col+1], mem[row+1][col+1]) + inpmat[row][col];
                }
                else{
                    mem[row][col]= Math.max(Math.max(mem[row][col+1], mem[row+1][col+1]),mem[row-1][col+1]) + inpmat[row][col];
                }
            }
        }
        int maxgold=0;
        for(int i=0;i<r;i++)
        {
            if(maxgold<mem[i][0]){

                maxgold=mem[i][0];
            }
        }
        return maxgold;
    }



    public static void main(String[] args) {
        //taking input for the matrix
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of rows:");
        int r = sc.nextInt();
        System.out.println("enter no of cols:");
        int c = sc.nextInt();
        //creating input matrix
        System.out.println("enter your matrix:");
        int [][] inpmat = new int [r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                inpmat[i][j] = sc.nextInt();
            }
        }
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
        System.out.println(goldmine(mem,inpmat));

        System.out.println("memory matrix:");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               System.out.print( mem[i][j] +" " );
            }
            System.out.println();
        }
    }
}
