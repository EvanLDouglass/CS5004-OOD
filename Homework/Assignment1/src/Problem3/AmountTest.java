package Problem3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for class Amount.
 * @author evandouglass
 */
public class AmountTest {

    @Test
    public void setUpAndTest() {
        Amount a = new Amount(-100, -100);
        assertEquals(new Amount(0, 0), a);

        a = new Amount(-100, 45);
        assertEquals(new Amount(0, 45), a);

        a = new Amount(-100, 500);
        assertEquals(new Amount(5, 0), a);

        a = new Amount(100, 500);
        assertEquals(new Amount(105, 0), a);

        a = new Amount(100, 550);
        assertEquals(new Amount(105, 50), a);
    }

    @Test
    public void add() {
        Amount a1 = new Amount();  // Zeroed
        assertEquals(new Amount(), a1.add(new Amount()));
        Amount a2 = new Amount(50, 10);
        assertEquals(a2, a1.add(a2));

        // Add after set dollars
        a1.setDollars(100);
        assertEquals(new Amount(150, 10), a1.add(a2));

        // Add after set cents
        a2.setCents(55);
        assertEquals(new Amount(150, 55), a2.add(a1));

        // Swap parameters
        assertEquals(new Amount(150, 55), a2.add(a1));
        // Add to self
        assertEquals(new Amount(200, 0), a1.add(a1));

        Amount a3 = new Amount(123, 45).add(new Amount(200, 50));
        assertEquals(new Amount(323, 95), a3);
        assertEquals(new Amount(350, 45), a3.add(new Amount(26, 50)));
    }

    @Test
    public void subtract() {
        Amount a1 = new Amount();  // Zeroed
        assertEquals(new Amount(), a1.subtract(new Amount()));
        Amount a2 = new Amount(50, 10);
        assertEquals(a2, a2.subtract(a1));

        // Add after set dollars
        a1.setDollars(100);
        assertEquals(new Amount(49, 90), a1.subtract(a2));

        // Add after set cents
        a1.setCents(55);
        assertEquals(new Amount(50, 45), a1.subtract(a2));
        a2.setCents(95);
        assertEquals(new Amount(49, 60), a1.subtract(a2));

        // Subtract from self
        assertEquals(new Amount(), a1.subtract(a1));

        Amount a3 = new Amount(123, 45).subtract(new Amount(20, 50));
        assertEquals(new Amount(102, 95), a3);
        assertEquals(new Amount(80, 45), a3.subtract(new Amount(22, 50)));

        // When subtracting bigger numbers
        a1 = new Amount(500, 0);
        assertEquals(new Amount(), a2.subtract(a1));
        a2 = new Amount(0, 55000);
        assertEquals(new Amount(), a1.subtract(a2));
    }

    @Test
    public void toString1() {
        Amount a = new Amount();
        assertEquals("Amount{$0.00}", a.toString());
        a = a.add(new Amount(20, 56));
        assertEquals("Amount{$20.56}", a.toString());
        a.setCents(450);
        assertEquals("Amount{$24.50}", a.toString());
    }

    @Test
    public void equals1() {
        Amount a1 = new Amount();
        Amount a2 = new Amount();
        assertEquals(a1, a2);
        a1.setDollars(35);
        assertNotEquals(a1, a2);
        a2.setDollars(35);
        assertEquals(a1, a2);
        a1.setCents(35);
        assertNotEquals(a1, a2);
        a2.setCents(35);
        assertEquals(a1, a2);
    }

    @Test
    public void setAndGetCents() {
        Amount a = new Amount();
        assertEquals(0, a.getCents());
        a = new Amount(40, 23);
        assertEquals(23, a.getCents());

        a.setCents(67);
        assertEquals(67, a.getCents());
        a.setCents(0);
        assertEquals(0, a.getCents());
        a.setCents(99);
        assertEquals(99, a.getCents());


        // Test bad sets
        a.setDollars(0);
        a.setCents(100);
        assertEquals(0, a.getCents());
        assertEquals(1, a.getDollars());
        a.setDollars(0);
        a.setCents(250);
        assertEquals(50, a.getCents());
        assertEquals(2, a.getDollars());

        a.setCents(-400);
        assertEquals(0, a.getCents());
        // set should be isolated, so does not affect dollars
    }

    @Test
    public void setAndGetDollars() {
        Amount a = new Amount();
        assertEquals(0, a.getDollars());
        a = new Amount(40, 23);
        assertEquals(40, a.getDollars());

        a.setDollars(67);
        assertEquals(67, a.getDollars());
        a.setDollars(0);
        assertEquals(0, a.getDollars());
        a.setDollars(99);
        assertEquals(99, a.getDollars());
        a.setDollars(700);
        assertEquals(700, a.getDollars());

        // Test bad sets
        a.setDollars(-500);
        assertEquals(0, a.getDollars());
    }
}