import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HouseTest {
    House house = new House();

    public HouseTest() {
        house.floorsFillUpWithDoorsAndWindows(1,5,5);
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void isHeaterWorks() {

        house.turnOnHeater();
        boolean heaterStatus = house.isHeaterWorks();
        assertTrue(heaterStatus);

        house.turnOffHeater();
        heaterStatus = house.isHeaterWorks();
        assertFalse(heaterStatus);
    }

    @Test
    public void turnOnHeater() {
        house.turnOnHeater();
        assertTrue(house.isHeaterWorks());
    }

    @Test
    public void turnOffHeater() {
        house.turnOffHeater();
        assertFalse(house.isHeaterWorks());
    }


}