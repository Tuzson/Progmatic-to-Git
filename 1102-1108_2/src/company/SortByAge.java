package company;

import java.util.Comparator;

public class SortByAge implements Comparator<PetOwner> {

    @Override
    public int compare(PetOwner o1, PetOwner o2) {
        return o1.getAge()-o2.getAge();
    }
}
