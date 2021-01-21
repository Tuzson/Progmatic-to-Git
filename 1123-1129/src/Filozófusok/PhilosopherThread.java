package Filozófusok;

public class PhilosopherThread extends Thread {

    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private boolean hasForkOnTheLeftHand;
    private boolean hasForkOnTheRightHand;
    private boolean thinking = true;

    public PhilosopherThread(String name) {
        super(name);


    }

    @Override
    public void run() {
        while (true) {
            try {
                tryToEat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void pickUpTheFork(Fork fork) {

        fork.setForkBusy();


    }

    public void putDownTheFork(Fork fork) {

        fork.setForkFree();

    }

    public void tryToEat() throws InterruptedException {

        switch (Thread.currentThread().getName()){
            case "Platón" : if (leftFork.isForkFree()){
                synchronized (leftFork) {
                    pickUpTheFork(leftFork);
                    hasForkOnTheLeftHand = true;
                }
            }
            else if (hasForkOnTheLeftHand){

            }
            else {
                System.out.println("Thinking");
            }
            if (rightFork.isForkFree()){
                synchronized (rightFork) {
                    pickUpTheFork(rightFork);
                    hasForkOnTheRightHand = true;
                    System.out.println("eat");
                    sleep(1000);
                    putDownTheFork(leftFork);
                    hasForkOnTheLeftHand = false;
                    putDownTheFork(rightFork);
                    hasForkOnTheRightHand = false;
                }
            }
            case "Konfucius" : if (leftFork.isForkFree()){
                synchronized (leftFork) {
                    pickUpTheFork(leftFork);
                    hasForkOnTheLeftHand = true;
                }
            }
            else if (hasForkOnTheLeftHand){

            }
            else {
                System.out.println("Thinking");
            }
                if (rightFork.isForkFree()){
                    synchronized (rightFork) {
                        pickUpTheFork(rightFork);
                        hasForkOnTheRightHand = true;
                        System.out.println("eat");
                        sleep(1000);
                        putDownTheFork(leftFork);
                        hasForkOnTheLeftHand = false;
                        putDownTheFork(rightFork);
                        hasForkOnTheRightHand = false;
                    }
                }
            case "Szókratész" : if (leftFork.isForkFree()){
                synchronized (leftFork) {
                    pickUpTheFork(leftFork);
                    hasForkOnTheLeftHand = true;
                }
            }
            else if (hasForkOnTheLeftHand){

            }
            else {
                System.out.println("Thinking");
            }
                if (rightFork.isForkFree()){
                    synchronized (rightFork) {
                        pickUpTheFork(rightFork);
                        hasForkOnTheRightHand = true;
                        System.out.println("eat");
                        sleep(1000);
                        putDownTheFork(leftFork);
                        hasForkOnTheLeftHand = false;
                        putDownTheFork(rightFork);
                        hasForkOnTheRightHand = false;
                    }
                }
            case "Voltaire" : if (leftFork.isForkFree()){
                synchronized (leftFork) {
                    pickUpTheFork(leftFork);
                    hasForkOnTheLeftHand = true;
                }
            }
            else if (hasForkOnTheLeftHand){

            }
            else {
                System.out.println("Thinking");
            }
                if (rightFork.isForkFree()){
                    synchronized (rightFork) {
                        pickUpTheFork(rightFork);
                        hasForkOnTheRightHand = true;
                        System.out.println("eat");
                        sleep(1000);
                        putDownTheFork(leftFork);
                        hasForkOnTheLeftHand = false;
                        putDownTheFork(rightFork);
                        hasForkOnTheRightHand = false;
                    }
                }
            case "Descartes" : if (leftFork.isForkFree()){
                synchronized (leftFork) {
                    pickUpTheFork(leftFork);
                    hasForkOnTheLeftHand = true;
                }
            }
            else if (hasForkOnTheLeftHand){

            }
            else {
                System.out.println("Thinking");
            }
                if (rightFork.isForkFree()){
                    synchronized (rightFork) {
                        pickUpTheFork(rightFork);
                        hasForkOnTheRightHand = true;
                        System.out.println("eat");
                        sleep(1000);
                        putDownTheFork(leftFork);
                        hasForkOnTheLeftHand = false;
                        putDownTheFork(rightFork);
                        hasForkOnTheRightHand = false;
                    }
                }
        }

    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }
}
