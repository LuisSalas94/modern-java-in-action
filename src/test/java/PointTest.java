import org.fernando.salas.part09.testing.Point;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {
    @Test
    public void testMoveRightBy() throws Exception {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }
}
