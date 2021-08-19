package math;

public class GCD {

    public static long gcd(long a, long b) {
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (a == 0) {
            return b;
        }
        return gcd(a, b % a);
    }

}
