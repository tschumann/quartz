package quartz.engine.common;

import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testToString() {
        Vector vector = new Vector(1, 2, 3);
        assertEquals("(1.0,2.0,3.0)", vector.toString());
    }
}
