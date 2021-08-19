package math;

public class NCR {
    private final long[] fact;
    private final long[] inv;
    private final long[] invfact;
    private final int MOD = 1_000_000_007;
    private final int n;

    public NCR(int n) {
        this.n = n;
        fact = new long[n];
        inv = new long[n];
        invfact = new long[n];
        factInverse();
    }

    public int nCr(int n, int r) {
        if (r > n) {
            return 0;
        }
        return (int) ((((fact[n] * invfact[r]) % MOD) * invfact[n - r]) % MOD);
    }

    private void factInverse() {
        fact[0] = inv[1] = fact[1] = invfact[0] = invfact[1] = 1;
        for (int i = 2; i < n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            inv[i] = MOD - (inv[MOD % i] * (MOD / i) % MOD);
            invfact[i] = (inv[i] * invfact[i - 1]) % MOD;
        }
    }
}
