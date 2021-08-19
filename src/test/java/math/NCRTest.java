package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NCRTest {

    @Test
    public void nCrTest() {
        NCR ncr = new NCR(10000);

        Assertions.assertEquals(1, ncr.nCr(1, 1));
        Assertions.assertEquals(2, ncr.nCr(2, 1));
        Assertions.assertEquals(15, ncr.nCr(6, 4));
        Assertions.assertEquals(302505679, ncr.nCr(1000, 10));
    }

}