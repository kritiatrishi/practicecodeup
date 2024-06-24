package org.practice.concepts;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LargeNumbers {
    static BigInteger factorial(int num){
        BigInteger ans=new BigInteger("1");
        for(int i=2;i<=num;i++){
            ans=ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    static void BD(){
        //floating points not precise answer
        double x=0.03;
        double y=0.04;
        double ans=y-x;
        System.out.println(ans);
        BigDecimal X=new BigDecimal("0.03");
        BigDecimal Y=new BigDecimal("0.04");
        BigDecimal A=Y.subtract(X);
        System.out.println(A);
    }
    public static void main(String[] args) {
        int a=30;
        int b=67;
        BigInteger A=BigInteger.valueOf(33);//converting int/long to BI
        BigInteger B=BigInteger.valueOf(332434631);
        //BigInteger C=BigInteger.valueOf(Long.parseLong("13242351"));
        BigInteger C=new BigInteger("13242351");
        int i=B.intValue();//int value of BI
        //constants
        BigInteger D=BigInteger.TEN;
        //addition
        BigInteger s=A.add(B);
        //multiply
        BigInteger m=A.multiply(B);
        //comparison
        if(m.compareTo(s)>0){
            System.out.println("Yes");

        }
        System.out.println(factorial(80));
        BD();

    }
}
