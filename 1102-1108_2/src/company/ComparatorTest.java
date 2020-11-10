package company;

import java.util.Comparator;

public class ComparatorTest implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        if (o1.getAge() > o2.getAge()) {
            return o1.getAge();
        }
        return o2.getAge();
    }
}
