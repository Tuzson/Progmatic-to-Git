package company;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByAnimalAge implements Comparator<ArrayList <Pet>>  {

    @Override
    public int compare(ArrayList<Pet> o1, ArrayList<Pet> o2) {
        for (int i = 0; i < o1.size(); i++) {
            if (o1.get(i).getAge() > o2.get(i).getAge()){
                return o1.get(i).getAge();

            }
            else {
                return o2.get(i).getAge();
            }
        }
        return 0;
    }
}
