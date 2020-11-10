package com.company;

import java.util.Comparator;

public class SortByName implements Comparator<Artist> {

    @Override
    public int compare(Artist o1, Artist o2) {
        if ((o1.getAwardYear() != 2013 && (o2.getAwardYear() != 2013))) {
            return 0;
        }
        if (o1.getAwardYear() != 2013 && o2.getAwardYear() == 2013) {
            return 1;
        }
        if (o1.getAwardYear() == 2013 && o2.getAwardYear() != 2013) {
            return -1;

        }
        return o1.getName().compareTo(o2.getName());
    }
}
