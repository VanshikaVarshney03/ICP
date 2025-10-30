import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long t=sc.nextLong();
        long[] a=new long[n];
        for(int i=0;i<n;i++) 
            a[i]=sc.nextLong();
        int left=0;
        long sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            while(sum>t){
                sum-=a[left];
                left++;
            }
            max=Math.max(max,i-left+1);
        }
        System.out.println(max);
    }
}
