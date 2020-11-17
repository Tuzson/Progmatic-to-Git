package com.company.Interface;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;

public class LazyGuy implements TimeAware {
    @Override
    public void currentTime(LocalDateTime currentTime) {

        if (currentTime.getHour()>=20 || currentTime.getHour() <11){
            System.out.println("hagyj aludni!");
        }
        else {
            System.out.println("Kösz, hogy szóltál");
        }

    }
}
