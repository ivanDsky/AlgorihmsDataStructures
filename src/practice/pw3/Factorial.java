package practice.pw3;

import java.math.BigInteger;

public class Factorial {
    public BigInteger getFactorial(int n) throws Exception {
        if(n < 0)throw new Exception("Factorial >= 0");
        BigInteger current = BigInteger.ONE;
        BigInteger mul = BigInteger.ONE;
        for(int i = 1;i <= n; ++i){
            current = current.multiply(mul);
            mul = mul.add(BigInteger.ONE);
        }
        return current;
    }
}
