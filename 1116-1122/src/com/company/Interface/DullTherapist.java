package com.company.Interface;

public class DullTherapist implements IntelligentInterface {


    @Override
    public String communication(String text) {
        int random = (int)(Math.random()*4+1);
        switch (random){
            case 1: return "Kérem, folytassa";
            case 2: return "Biztos ebben?";
            case 3: return "Csakugyan?";
        }
        return "Nem tudom. Talán így van. Ön mit gondol erről?";
    }
}
