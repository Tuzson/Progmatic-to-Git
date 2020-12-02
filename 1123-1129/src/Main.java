public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.floorsFillUpWithDoorsAndWindows(1, 4, 5);
        SmartRemote smartRemote = new SmartRemote(house);
        smartRemote.closeAllWindows();
        smartRemote.turnOnTheHeater();
        smartRemote.dryAndOpenSmallWindows();
    }
}
