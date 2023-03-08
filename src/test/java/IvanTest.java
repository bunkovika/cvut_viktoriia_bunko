import cz.fel.cvut.ts1.Ivan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IvanTest {
    @Test
    public void factorialTest(){
        Assertions.assertEquals(2, Ivan.factorialRecursive(2));
        Assertions.assertEquals(120, Ivan.factorialIterative(5));
    }
}
