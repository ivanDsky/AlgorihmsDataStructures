package practice.pw3;

import java.math.BigInteger;

public class FactorialCash {
    public final static int ARRAY_LIMIT = 20;
    public static int preCount;
    public static BigInteger[] preFact = new BigInteger[ARRAY_LIMIT + 1];
    private static BigInteger mul = BigInteger.ONE;

    public FactorialCash() {
        preFact[0] = mul;
    }

    public BigInteger getFactorial(int n) throws Exception{
        if(n < 0 || n > ARRAY_LIMIT){
            throw new Exception("Cashed factorial can be only from 0! to 20!");
        }
        if(n <= preCount){
            System.out.println("Factorial was in cash.");
            return preFact[n];
        }
        System.out.println("Precalculated factorial is " + preCount);
        for(int i = preCount + 1;i <= n; ++i){
            preFact[i] = preFact[i - 1].multiply(mul);
            mul = mul.add(BigInteger.ONE);
        }
        preCount = n;
        return preFact[n];
    }

}
