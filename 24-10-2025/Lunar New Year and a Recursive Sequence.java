import java.util.*;
public class Main{
    static final long P=998244353L,PR=3L,MODE=P-1;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        long[] b=new long[k];
        for(int i=0;i<k;i++)
            b[i]=sc.nextLong()%MODE;
        long n=sc.nextLong(),m=sc.nextLong();
        long y;
        if(m==1)y=0;
        else{
            long dlog=discreteLog(PR,m,P);
            if(dlog==-1){
                System.out.println(-1);return;}
            y=dlog;
        }
        long[][] A=new long[k][k];
        for(int j=0;j<k;j++)
            A[0][j]=b[j]%MODE;
        for(int i=1;i<k;i++)
            A[i][i-1]=1;
        long[][] Aexp=matPow(A,n-k,MODE);
        long C=Aexp[0][0]%MODE,g=gcd(C,MODE);
        if(y%g!=0){
            System.out.println(-1);return;
        }
        long modReduced=MODE/g,Cred=C/g,yred=(y/g)%modReduced;
        if(yred<0)yred+=modReduced;
        long invCred=modInverse(Cred%modReduced,modReduced);
        if(invCred==-1){
            System.out.println(-1);return;}
        long x=(yred*invCred)%modReduced;
        System.out.println(modPow(PR,x,P));
    }
    static long[][] matMul(long[][] A,long[][] B,long mod){
        int n=A.length,m=B[0].length,c=B.length;
        long[][] C=new long[n][m];
        for(int i=0;i<n;i++)
            for(int k=0;k<c;k++){
            if(A[i][k]==0)
                continue;
            long v=A[i][k];
            for(int j=0;j<m;j++)C[i][j]=(C[i][j]+v*B[k][j])%mod;
        }
        return C;
    }
    static long[][] matPow(long[][] A,long e,long mod){
        int n=A.length;
        long[][] res=new long[n][n];
        for(int i=0;i<n;i++)res[i][i]=1;
        long[][] base=new long[n][n];
        for(int i=0;i<n;i++)
            System.arraycopy(A[i],0,base[i],0,n);
        while(e>0){
            if((e&1)==1)
                res=matMul(res,base,mod);
            base=matMul(base,base,mod);
            e>>=1;
        }
        return res;
    }
    static long discreteLog(long a,long b,long p){
        a%=p;b%=p;
        if(b==1)
            return 0;
        long m=(long)
            Math.ceil(Math.sqrt(p-1));
        Map<Long,Long> baby=new HashMap<>();
        long aj=1;
        for(long j=0;j<m;j++){
            if(!baby.containsKey(aj))
                baby.put(aj,j);
                aj=(aj*a)%p;}
        long am=modPow(a,m,p),amInv=modInverse(am,p);
        if(amInv==-1)
            return-1;
        long cur=b;
        for(long i=0;i<=m;i++){
            Long j=baby.get(cur);
            if(j!=null)
                return(i*m+j)%(p-1);
            cur=(cur*amInv)%p;
        }
        return-1;
    }
    static long modPow(long a,long e,long mod){
        a%=mod;
        long r=1%mod;
        while(e>0){
            if((e&1)==1)
                r=(r*a)%mod;
            a=(a*a)%mod;e>>=1;
        }
        return r;
    }
    static long gcd(long a,long b){
        while(b!=0){
            long t=a%b;a=b;b=t;
        }
        return Math.abs(a);}
    static long modInverse(long a,long mod){
        a%=mod;
        if(a<0)
            a+=mod;
        long[] eg=extGcd(a,mod);
        long g=eg[0],x=eg[1];
        if(g!=1)
            return-1;
        x%=mod;
        if(x<0)
            x+=mod;
        return x;
    }
    static long[] extGcd(long a,long b){
        if(b==0)
            return new long[]{a,1,0};
        long[] t=extGcd(b,a%b);
        long g=t[0],x1=t[1],y1=t[2];
        return new long[]{g,y1,x1-(a/b)*y1};
    }
}
