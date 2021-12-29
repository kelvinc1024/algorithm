package math;

public class MathOps {

    public static long gcd(long a, long b) {
        while (b != 0) {
            a %= b;

            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long modpow(long x, long n, int mod) {
        if (x == 0 && n == 0) return 0; // undefined case
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = (res * x) % mod;
            x = (x * x) % mod;
            n /= 2;
        }
        return res;
    }

    public static long modinv(long x, int mod) {
        return modpow(x, mod - 2, mod);
    }

}
