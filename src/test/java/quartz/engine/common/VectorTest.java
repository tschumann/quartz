package quartz.engine.common;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {

    @Test
    public void testToString() {
        Vector vector = new Vector(1, 2, 3);
        Assert.assertEquals("(1.0,2.0,3.0)", vector.toString());
    }

    @Test
    public void testGetters() {
        Vector vector = new Vector(3, 4, 5);
        Assert.assertEquals("The roll is correct", 3, vector.getRoll(), 0.0);
        Assert.assertEquals("The pitch is correct", 4, vector.getPitch(), 0.0);
        Assert.assertEquals("The yaw is correct", 5, vector.getYaw(), 0.0);
    }

    @Test
    public void testEquality() {
        Vector vector = new Vector(1, 1, 1);

        Assert.assertTrue(vector.equals(vector));

        Object object = new Object();

        Assert.assertFalse(vector.equals(object));

        Assert.assertTrue(vector.equals(new Vector(1, 1, 1)));

        Assert.assertFalse(vector.equals(new Vector(1 + Maths.EPSILON, 1  + Maths.EPSILON, 1  + Maths.EPSILON)));
    }
}
