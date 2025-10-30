import java.util.*;
public class Main {
    static double fact(int n){
        double res=1;
        for(int i=2;i<=n;i++)res*=i;
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int target=0,cur=0,q=0;
        for(char c:s1.toCharArray())
            target+=c=='+'?1:-1;
        for(char c:s2.toCharArray()){
            if(c=='+')
                cur++;
            else if(c=='-')
                cur--;
            else 
                q++;
        }
        int diff=target-cur;
        if((diff+q)%2!=0||Math.abs(diff)>q){
            System.out.printf("%.12f\n",0.0);
            return;
        }
        int plusNeeded=(diff+q)/2;
        double ways=fact(q)/(fact(plusNeeded)*fact(q-plusNeeded));
        double prob=ways/Math.pow(2,q);
        System.out.printf("%.12f\n",prob);
    }
}
