import java.util.*;
public class Main{
    static int MAX=1000000;
    static int[] g=new int[MAX+1];
    static int[][] p=new int[10][MAX+1];
    public static void main(String[] args){
        fun();
        Scanner sc=new Scanner(System.in);
        int Q=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(Q-- >0){
            int l=sc.nextInt(),r=sc.nextInt(),k=sc.nextInt();
            sb.append(p[k][r]-p[k][l-1]).append("\n");
        }
        System.out.print(sb);
    }
    static void fun(){
        for(int i=1;i<=MAX;i++){
            g[i]=get(i);
            for(int k=1;k<=9;k++){
                p[k][i]=p[k][i-1]+(g[i]==k?1:0);
            }
        }
    }
    static int get(int x){
        if(x<10)return x;
        return get(pro(x));
    }
    static int pro(int x){
        int p=1;
        while(x>0){
            int d=x%10;
            if(d!=0)p*=d;
            x/=10;
        }
        return p;
    }
}
