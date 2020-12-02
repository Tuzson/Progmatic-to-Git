import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class House implements SmartHouse {
    private boolean heater;
    private Map<Windows_Door, ArrayList<Boolean>> firstFloor;
    private Map<Windows_Door, ArrayList<Boolean>> secondFloor;

    public House() {
        firstFloor = new HashMap<>();
        secondFloor = new HashMap<>();
        int random = (int) (Math.random() * 2);
        heater = random != 0;
    }

    @Override
    public boolean isHeaterWorks() {
        return heater;
    }

    @Override
    public void turnOnHeater() {
        heater = true;
    }

    @Override
    public void turnOffHeater() {
        heater = false;
    }

    @Override
    public boolean windowsStatus() {
        int random = (int) (Math.random() * 2);
        return random != 0;
    }

    public void floorsFillUpWithDoorsAndWindows(int nrOfDoorOnFirstFloor, int firstFloorWindowsNr, int secondFloorWindowsNr) {
        int i = 0;
        while (nrOfDoorOnFirstFloor > i) {
            firstFloor.putIfAbsent(Windows_Door.DOOR, new ArrayList<>());
            firstFloor.get(Windows_Door.DOOR).add(windowsStatus());
            i++;
        }
        i = 0;
        while (firstFloorWindowsNr > i) {
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                firstFloor.putIfAbsent(Windows_Door.SMALLWINDOW, new ArrayList<>());
                firstFloor.get(Windows_Door.SMALLWINDOW).add(windowsStatus());

            } else {
                firstFloor.putIfAbsent(Windows_Door.LARGEWINDOW, new ArrayList<>());
                firstFloor.get(Windows_Door.LARGEWINDOW).add(windowsStatus());
            }
            i++;
        }
        i = 0;
        while (secondFloorWindowsNr > i) {
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                secondFloor.putIfAbsent(Windows_Door.SMALLWINDOW, new ArrayList<>());
                secondFloor.get(Windows_Door.SMALLWINDOW).add(windowsStatus());
            } else {
                secondFloor.putIfAbsent(Windows_Door.LARGEWINDOW, new ArrayList<>());
                secondFloor.get(Windows_Door.LARGEWINDOW).add(windowsStatus());
            }
            i++;
        }
    }

    public void showTheDoorsAndWindowsStatus() {

        if (isHeaterWorks()) {
            System.out.println("Í");
        } else {
            System.out.println("I");
        }

        for (int i = 0; i < secondFloor.get(Windows_Door.SMALLWINDOW).size(); i++) {
            if (secondFloor.get(Windows_Door.SMALLWINDOW).get(i)) {
                System.out.print("\u25A0" + " ");
            } else if (!secondFloor.get(Windows_Door.SMALLWINDOW).get(i)) {
                System.out.print("\u25A1" + " ");
            }

        }
        for (int i = 0; i < secondFloor.get(Windows_Door.LARGEWINDOW).size(); i++) {
            if (secondFloor.get(Windows_Door.LARGEWINDOW).get(i)) {
                System.out.print("\u25A0" + " ");
            } else if (!secondFloor.get(Windows_Door.LARGEWINDOW).get(i)) {
                System.out.print("\u25A1" + " ");
            }

        }
        System.out.println();

        for (int i = 0; i < firstFloor.get(Windows_Door.SMALLWINDOW).size(); i++) {
            if (firstFloor.get(Windows_Door.SMALLWINDOW).get(i)) {
                System.out.print("\u25A0" + " ");
            } else if (!firstFloor.get(Windows_Door.SMALLWINDOW).get(i)) {
                System.out.print("\u25A1" + " ");
            }
        }

        for (int i = 0; i < firstFloor.get(Windows_Door.DOOR).size(); i++) {
            if (firstFloor.get(Windows_Door.DOOR).get(i)) {
                System.out.print("\u25AE" + " ");
            } else if (!firstFloor.get(Windows_Door.DOOR).get(i)) {
                System.out.print("\u25AF" + " ");
            }
        }

        for (int i = 0; i < firstFloor.get(Windows_Door.LARGEWINDOW).size(); i++) {
            if (firstFloor.get(Windows_Door.LARGEWINDOW).get(i)) {
                System.out.print("\u25A0" + " ");
            } else if (!firstFloor.get(Windows_Door.LARGEWINDOW).get(i)) {
                System.out.print("\u25A1" + " ");
            }
        }
        System.out.println();
    }


    public Map<Windows_Door, ArrayList<Boolean>> getFirstFloor() {
        return firstFloor;
    }

    public void setFirstFloor(Map<Windows_Door, ArrayList<Boolean>> firstFloor) {
        this.firstFloor = firstFloor;
    }

    public Map<Windows_Door, ArrayList<Boolean>> getSecondFloor() {
        return secondFloor;
    }

    public void setSecondFloor(Map<Windows_Door, ArrayList<Boolean>> secondFloor) {
        this.secondFloor = secondFloor;
    }
}