package Filozófusok;

import java.util.ArrayList;

public class Table {

   private ArrayList<Fork> forks = new ArrayList<>();
   private ArrayList<PhilosopherThread> philosopherThreads = new ArrayList<>();

    public Table(int nrOfForks) {
        for (int i = 0; i < nrOfForks; i++) {
            forks.add(new Fork());
            forks.get(i).setForkNr(i);
        }
        philosopherThreads.add(new PhilosopherThread("Platón"));
        philosopherThreads.add(new PhilosopherThread("Konfucius"));
        philosopherThreads.add(new PhilosopherThread("Szókratész"));
        philosopherThreads.add(new PhilosopherThread("Voltaire"));
        philosopherThreads.add(new PhilosopherThread("Descartes"));
    }

    public ArrayList<Fork> getForks() {
        return forks;
    }

    public void setForks(ArrayList<Fork> forks) {
        this.forks = forks;
    }

    public ArrayList<PhilosopherThread> getPhilosopherThreads() {
        return philosopherThreads;
    }

    public void setPhilosopherThreads(ArrayList<PhilosopherThread> philosopherThreads) {
        this.philosopherThreads = philosopherThreads;
    }
}
