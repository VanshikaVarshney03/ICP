import java.util.*;
public class Main{
    static int maxBeauty(String s,int k,char target){
        int left=0;
        int max=0;
        int changes=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)!=target)changes++;
            while(changes>k){
                if(s.charAt(left)!=target)changes--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String s=sc.next();
        int ans=Math.max(maxBeauty(s,k,'a'),maxBeauty(s,k,'b'));
        System.out.println(ans);
    }
}
