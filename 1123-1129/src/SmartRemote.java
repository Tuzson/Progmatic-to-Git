public class SmartRemote {

    private House house;

    public SmartRemote(House house) {
        this.house = house;
    }

    public void closeAllWindows() {
        if (house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size() > 0) {
            for (int i = 0; i < house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
                if (house.getFirstFloor().get(Windows_Door.SMALLWINDOW).get(i)) {
                    house.getFirstFloor().get(Windows_Door.SMALLWINDOW).set(i, false);
                }
            }
        }
        if (house.getFirstFloor().get(Windows_Door.LARGEWINDOW).size() > 0)
            for (int i = 0; i < house.getFirstFloor().get(Windows_Door.LARGEWINDOW).size(); i++) {
                if (house.getFirstFloor().get(Windows_Door.LARGEWINDOW).get(i)) {
                    house.getFirstFloor().get(Windows_Door.LARGEWINDOW).set(i, false);
                }
            }
        for (int i = 0; i < house.getFirstFloor().get(Windows_Door.DOOR).size(); i++) {
            if (house.getFirstFloor().get(Windows_Door.DOOR).get(i)) {
                house.getFirstFloor().get(Windows_Door.DOOR).set(i, false);
            }
        }
        if (house.getSecondFloor().get(Windows_Door.SMALLWINDOW).size() > 0)
            for (int i = 0; i < house.getSecondFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
                if (house.getSecondFloor().get(Windows_Door.SMALLWINDOW).get(i)) {
                    house.getSecondFloor().get(Windows_Door.SMALLWINDOW).set(i, false);
                }
            }
        if (house.getSecondFloor().get(Windows_Door.LARGEWINDOW).size() > 0)
            for (int i = 0; i < house.getSecondFloor().get(Windows_Door.LARGEWINDOW).size(); i++) {
                if (house.getSecondFloor().get(Windows_Door.LARGEWINDOW).get(i)) {
                    house.getSecondFloor().get(Windows_Door.LARGEWINDOW).set(i, false);
                }
            }
        house.showTheDoorsAndWindowsStatus();
        System.out.println("Windows and Door(s) are closed:" + "\n");
    }

    public void turnOnTheHeater() {
        if (!house.isHeaterWorks()) {
            house.turnOnHeater();

        }
        closeAllWindows();
        System.out.println("Heater is turned on" + "\n");
    }

    public void dryAndOpenSmallWindows() {
        closeAllWindows();
        for (int i = 0; i < house.getFirstFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
            house.getFirstFloor().get(Windows_Door.SMALLWINDOW).set(i, true);

        }
        for (int i = 0; i < house.getSecondFloor().get(Windows_Door.SMALLWINDOW).size(); i++) {
            house.getSecondFloor().get(Windows_Door.SMALLWINDOW).set(i, true);
        }
        house.showTheDoorsAndWindowsStatus();
        System.out.println("Small windows were opened" + "\n");
    }
}