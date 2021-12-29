package math;

public class SimpleNCR {

    private final long[] fact;
    private final long[] invfact;
    private final int MOD = 1_000_000_007;
    private final int n;

    public SimpleNCR(int n) {
        this.n = n;
        fact = new long[n];
        invfact = new long[n];
        precalc();
    }

    public int nCr(int n, int r) {
        if (r > n) {
            return 0;
        }
        return (int) ((((fact[n] * invfact[r]) % MOD) * invfact[n - r]) % MOD);
    }

    private void precalc() {
        fact[0] = fact[1] = invfact[0] = invfact[1] = 1;
        for (int i = 2; i < n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invfact[i] = MathOps.modinv(fact[i], MOD);
        }
    }


}
