package quartz.engine.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorTest {

    @Test
    public void testToString() {
        Vector vector = new Vector(1, 2, 3);
        Assertions.assertEquals("(1.0,2.0,3.0)", vector.toString());
    }

    @Test
    public void testGetters() {
        Vector vector = new Vector(3, 4, 5);
        Assertions.assertEquals(3, vector.getRoll(), 0.0, "The roll is correct");
        Assertions.assertEquals(4, vector.getPitch(), 0.0, "The pitch is correct");
        Assertions.assertEquals(5, vector.getYaw(), 0.0, "The yaw is correct");
    }

    @Test
    public void testEquality() {
        Vector vector = new Vector(1, 1, 1);

        Assertions.assertTrue(vector.equals(vector));

        Object object = new Object();

        Assertions.assertFalse(vector.equals(object));

        Assertions.assertTrue(vector.equals(new Vector(1, 1, 1)));

        Assertions.assertFalse(vector.equals(new Vector(1 + Maths.EPSILON, 1  + Maths.EPSILON, 1  + Maths.EPSILON)));
    }
}
