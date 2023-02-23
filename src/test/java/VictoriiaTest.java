import cz.fel.cvut.ts1.Victoriia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VictoriiaTest {
    @Test
    public void factorialTest(){
        Assertions.assertEquals(2, Victoriia.factorialRecursive(2));
        Assertions.assertEquals(120, Victoriia.factorialIterative(5));
    }
}
