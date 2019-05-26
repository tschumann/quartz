package quartz.engine.common;

import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testToString() {
        Vector vector = new Vector(1, 2, 3);
        assertEquals("(1.0,2.0,3.0)", vector.toString());
    }

    @Test
    public void testGetters() {
        Vector vector = new Vector(3, 4, 5);
        assertEquals("The roll is correct", 3, vector.getRoll(), 0.0);
        assertEquals("The pitch is correct", 4, vector.getPitch(), 0.0);
        assertEquals("The yaw is correct", 5, vector.getYaw(), 0.0);
    }
}
