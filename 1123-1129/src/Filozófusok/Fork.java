package Filozófusok;

public class Fork {
    private boolean isForkFree;
    private int forkNr;

    public Fork() {
        isForkFree = true;
    }

    public boolean isForkFree() {
        return isForkFree;
    }

    public void setForkFree() {
        if (!isForkFree){
            isForkFree = true;
        }
    }
    public void setForkBusy() {
        if (isForkFree){
            isForkFree = false;
        }
    }

    public void setForkNr(int forkNr) {
        this.forkNr = forkNr;
    }

    public int getForkNr() {
        return forkNr;
    }
}
