package com.company.Interface;

import java.time.LocalDateTime;

public class HungryGuy implements TimeAware {
    @Override
    public void currentTime(LocalDateTime currentTime) {
        if (currentTime.getHour() == 8){
            System.out.println("Juhhuuu reggeli");
        }
        else if (currentTime.getHour()== 12){
            System.out.println("Juhhuuu ebéd");
        }
        else if (currentTime.getHour() == 18){
            System.out.println("Juhhuuu vacsora");
        }
        else {
            System.out.println("Juj de éhes vagyok");
        }
    }
}
