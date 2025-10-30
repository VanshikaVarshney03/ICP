import java.util.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
 
            int minSum = n * (a - b);
            int maxSum = n * (a + b);
 
            int minPackage = c - d;
            int maxPackage = c + d;
 
            if (maxSum >= minPackage && minSum <= maxPackage)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
 
        sc.close();
    }
}
