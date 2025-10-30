import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q=sc.nextInt();
        StringBuilder out=new StringBuilder();
        while(q-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            String s=sc.next();
            char[] a=s.toCharArray();
            int zeros=0; 
            StringBuilder res=new StringBuilder();
            for(int i=0;i<n;i++){
                if(a[i]=='0'){
                    long move=Math.min(k,i-zeros);
                    k-=move;
                    int pos=(int)(i-move);
                    a[i]='1';
                    a[pos]='0';
                    zeros++;
                }
            }
            for(char c:a) 
                res.append(c);
            out.append(res).append('\n');
        }
        System.out.print(out);
    }
}
