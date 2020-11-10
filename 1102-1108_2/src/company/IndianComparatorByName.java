package company;

import java.util.Comparator;

public class IndianComparatorByName  implements Comparator<Indian> {

    @Override
    public int compare(Indian o1, Indian o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
