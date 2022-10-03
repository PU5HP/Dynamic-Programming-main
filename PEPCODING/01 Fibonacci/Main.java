import java.util.*;

public class Main {

    // BASIC RECURSION METHOD TC-(O(2^n)) SC-O(n)
    public static int fib_rec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib_rec(n - 1) + fib_rec(n - 2);
    }

    // BASIC MEMOISATION WITH RECURSION METHOD TC-(O(n)) SC-O(n)
    public static int fib_REC_MEM(int n, int[] mem) {
        if (n == 0 || n == 1) {
            return mem[n] = n;
        }
        // if already calculated
        if (mem[n] != 0) {
            return mem[n];
        }
        int ans = fib_REC_MEM(n - 1, mem) + fib_REC_MEM(n - 2, mem);
        return mem[n] = ans;
    }

    // TABULATION METHOD ITERATON TC-(O(n)) SC-O(n) slightly better than basic
    // memoisationj with recursion method because of the less function call stack
    public static int fib_tab(int n, int[] mem2) {
        // initialize the first two values
        mem2[0] = 0;
        mem2[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem2[i] = mem2[i - 1] + mem2[i - 2];
        }
        return mem2[n];
    }

    // optimised tabulation method TC-(O{n}) SC-O(1)
    public static int fib_tab_opt(int n) {
        // initialize the first two values
        int first = 0;
        int sec = 1;
        int third = 0;
        for (int i = 2; i <= n; i++) {
            third = first + sec;
            first = sec;
            sec = third;
        }
        return third;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number whose fibo is to be found:");
        int n = sc.nextInt();
        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(fib_rec(n));
        int mem[] = new int[n + 1];
        System.out.println(fib_REC_MEM(n, mem));
        int mem2[] = new int[n + 1];
        System.out.println(fib_tab(n, mem2));
        System.out.println(fib_tab_opt(n));
    }
}