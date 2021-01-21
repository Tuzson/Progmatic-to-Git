package Filozófusok;

import java.util.ArrayList;

public class DiningPhilosophers {
    public static void main(String[] args) {

        Table table = new Table(5);

        table.getPhilosopherThreads().get(0).setLeftFork(table.getForks().get(1));
        table.getPhilosopherThreads().get(0).setRightFork(table.getForks().get(0));
        for (int i = 0; i < table.getPhilosopherThreads().size()-1; i++) {
            table.getPhilosopherThreads().get(i+1).setLeftFork(table.getForks().get(i+1));
            table.getPhilosopherThreads().get(i+1).setRightFork(table.getPhilosopherThreads().get(i).getLeftFork());
        }
        for (int i = 0; i < table.getPhilosopherThreads().size(); i++) {
            table.getPhilosopherThreads().get(i).start();
        }
    }
}
