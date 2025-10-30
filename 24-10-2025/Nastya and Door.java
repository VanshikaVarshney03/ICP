import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++) a[i]=sc.nextInt();
            int[] peaks=new int[n];
            for(int i=1;i<n-1;i++){
                if(a[i]>a[i-1] && a[i]>a[i+1]) peaks[i]=1;
            }
            int[] p=new int[n];
            p[0]=peaks[0];
            for(int i=1;i<n;i++) p
                [i]=p[i-1]+peaks[i];
            int max=0;
            int best=0;
            for(int l=0;l+k-1<n;l++){
                int r=l+k-1;
                int count=p[r-1]-p[l];
                if(count>max){
                    max=count;
                    best=l;
                }
            }
            System.out.println((max+1)+" "+(best+1));
        }
    }
}
