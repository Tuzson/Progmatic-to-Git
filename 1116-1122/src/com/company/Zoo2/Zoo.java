package com.company.Zoo2;

import java.util.ArrayList;

public class Zoo {
    ArrayList<Animal> animals = new ArrayList<>();
    Worker worker = new Worker("John");

    public void fillUpZoo(int nrOfAnimal) {

        for (int i = 0; i < nrOfAnimal; i++) {
            int random = (int) (Math.random() * 3 + 1);
            int age = (int) (Math.random() * 15 + 1);
            int gender = (int) (Math.random() * 2);
            switch (random) {
                case 1:
                    if (gender == 0) {
                        Animal lion = new Lion("Lion" + i, age, "male");
                        animals.add(lion);
                        worker.animalsToLookAfter.add(lion);
                        break;
                    }
                    Animal lion = new Lion("Lion" + i, age, "female");
                    animals.add(lion);
                    worker.animalsToLookAfter.add(lion);
                    break;
                case 2:
                    if (gender == 0) {
                        Animal monkey = new Monkey("Monkey" + i, age, "male");
                        animals.add(monkey);
                        worker.animalsToLookAfter.add(monkey);
                        break;
                    }
                    Animal monkey = new Monkey("Monkey" + i, age, "female");
                    animals.add(monkey);
                    worker.animalsToLookAfter.add(monkey);
                    break;
                case 3:
                    if (gender == 0) {
                        Animal elephant = new Elephant("Elephant" + i, age, "male");
                        animals.add(elephant);
                        worker.animalsToLookAfter.add(elephant);
                        break;
                    }
                    Animal elephant = new Elephant("Elephant" + i, age, "female");
                    animals.add(elephant);
                    worker.animalsToLookAfter.add(elephant);
                    break;
            }


        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animals=" + animals +
                ", worker=" + worker +
                '}';
    }
}
