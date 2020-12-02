import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartRemoteTest {

    House house = new House();
    SmartRemote smartRemote;

    public SmartRemoteTest() {
        house.floorsFillUpWithDoorsAndWindows(1,5,5);
        smartRemote = new SmartRemote(house);
    }

    @Test
    public void closeSmallWindowsOnTheFirstFloor(){
        int closedWindows = 0;
        int sum = house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size();
        for (int i = 0; i < house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
            if (house.getFirstFloor().get(Windows_Door.SMALLWINDOW).get(i)){
                house.getFirstFloor().get(Windows_Door.SMALLWINDOW).set(i,false);
            }
            closedWindows++;
        }
        assertEquals(sum,closedWindows);
    }

    @Test
    public void closeLargeWindowsOnTheFirstFloor(){
        int closedWindows = 0;
        int sum = house.getFirstFloor().get(Windows_Door.LARGEWINDOW).size();
        for (int i = 0; i < house.getFirstFloor().get(Windows_Door.LARGEWINDOW).size(); i++) {
            if (house.getFirstFloor().get(Windows_Door.LARGEWINDOW).get(i)){
                house.getFirstFloor().get(Windows_Door.LARGEWINDOW).set(i,false);
            }
            closedWindows++;
        }
        assertEquals(sum,closedWindows);
    }
    @Test
    public void openSmallWindows (){
        smartRemote.dryAndOpenSmallWindows();
        int sumSmallWindows;
        int sumOpenedSmallWindows = 0;
        sumSmallWindows = house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size() + house.getSecondFloor().get(Windows_Door.SMALLWINDOW).size();
        for (int i = 0; i < house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
            if (house.getFirstFloor().get(Windows_Door.SMALLWINDOW).get(i)){
                sumOpenedSmallWindows++;
            }
            else {
                Assert.fail("Nem nyitja ki az összes kis ablakot az első emeleten");
            }
        }
        for (int i = 0; i < house.getSecondFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
            if (house.getSecondFloor().get(Windows_Door.SMALLWINDOW).get(i)){
                sumOpenedSmallWindows++;
            }
            else if (!house.getSecondFloor().get(Windows_Door.SMALLWINDOW).get(i)){
                Assert.fail("Nem nyitja ki az összes kis ablakot a 2. emeleten");
            }

        }
        assertEquals(sumSmallWindows,sumOpenedSmallWindows);
    }
}