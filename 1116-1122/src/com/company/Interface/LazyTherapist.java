package com.company.Interface;

public class LazyTherapist implements IntelligentInterface {

    @Override
    public String communication(String text) {
        char c = text.charAt(text.length() - 1);
        if (c == '?') {
            int random = (int) (Math.random() * 4 + 1);
            switch (random) {
                case 1:
                    return "Miért gondolja ezt?";
                case 2:
                    return "Biztos ön ebben?";
                case 3:
                    return "El tudja képzelni ennek az ellenkezőjét is?";
                case 4:
                    return "Nem tudom. Talán így van. Ön mit gondol erről?";
            }
        } else if (c == '!') {
            int random = (int) (Math.random() * 3 + 1);
            switch (random) {
                case 1:
                    return "Most dühös lett?";
                case 2:
                    return "Mit érez miközben ezt mondja?";
                case 3:
                    return "Feszült lett attól, amiről beszélünk?";
            }
        } else {
            int random = (int) (Math.random() * 3 + 1);
            switch (random){
                case 1:
                    return "Kérem, folytassa";
                case 2:
                    return "Biztos ebben?";
                case 3:
                    return "Csakugyan?";
                case 4:
                    return "Hmm. Ez érdekes. Kérem fejtse ki bővebben!";
            }
        }
        return "-1";
    }
}
