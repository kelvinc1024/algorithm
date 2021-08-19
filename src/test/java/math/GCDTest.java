package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GCDTest {

    @Test
    void gcd() {
        Assertions.assertEquals(3, GCD.gcd(9, 6));
        Assertions.assertEquals(6, GCD.gcd(12, 6));
        Assertions.assertEquals(6, GCD.gcd(0, 6));
        Assertions.assertEquals(1, GCD.gcd(2, 3));
    }
}