package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathOpsTest {

    @Test
    void gcd() {
        Assertions.assertEquals(3, MathOps.gcd(9, 6));
        Assertions.assertEquals(6, MathOps.gcd(12, 6));
        Assertions.assertEquals(6, MathOps.gcd(0, 6));
        Assertions.assertEquals(1, MathOps.gcd(2, 3));
    }

    @Test
    void lcm() {
        Assertions.assertEquals(18, MathOps.lcm(9, 6));
        Assertions.assertEquals(12, MathOps.lcm(12, 6));
        Assertions.assertEquals(0, MathOps.lcm(0, 6));
        Assertions.assertEquals(6, MathOps.lcm(2, 3));
    }

    @Test
    void modpow() {
        Assertions.assertEquals(5, MathOps.modpow(5, 1, 1_000_000_007));

    }
}