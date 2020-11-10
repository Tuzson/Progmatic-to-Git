package company;

import java.util.Comparator;

public class IndianComparatorByAgeAndName implements Comparator<Indian> {

    @Override
    public int compare(Indian o1, Indian o2) {
        int ageDiff = o1.getAge() - o2.getAge();
        if(ageDiff != 0){
            return  ageDiff;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
