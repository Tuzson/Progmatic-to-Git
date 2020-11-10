package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TvMain {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<TV> tvArray = new ArrayList<>(fillUp());
        HashMap<String, ArrayList<String>> channels = new HashMap<>(sumChannels(tvArray));
        HashMap<String, ArrayList<String>> tvProgrammes = new HashMap<>(tvProgrammes(tvArray));
        System.out.println(tvProgrammes(tvArray));

        //Hány csatorna van összesen?
        System.out.println(channels.keySet().size());

        //Hány különböző műsor van?
        System.out.println(tvProgrammes.keySet().size());

        //Kérjen be a felhasználótól egy csatornát. Hány különböző műsort játszanak ezen a csatornán?

        System.out.println(differentProgram(tvArray,"Sky"));

        //Kérjen be a felhasználótól egy műsort. Hány csatornán adják a megadott műsort?

        System.out.println(nrOfChannelTheSelectedProgram(tvArray,"Daredevil"));

        //A megadott csatornán adják-e a megadott műsort?

        if (isPlayedProgram(tvArray,"HBO","Narcos")){
            System.out.println("A kért műsort játszák a csatornán ");
        }
        else {
            System.out.println("A kért műsort nem játszák ezen a csatornán");
        }
        //Melyik műsort játsszák a legtöbb csatornán?

        System.out.println(theMostPlayedProgram(tvArray));

       //Csatornánként hány különféle műsort adnak?
       nrOfDifferentProgramInChanels(tvArray);

       //Van -e olyan műsor, amelyet minden csatornán adnak?
        System.out.println(programInEveryChanel(tvArray));

        //Van-e olyan műsor, amit csak egyetlen csatornán adnak?
        System.out.println(programInOneChanel(tvArray));

    }
    public static ArrayList<TV> fillUp () throws FileNotFoundException {
        ArrayList<TV> arr = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/musorok2.txt"));
        for (int i = 0;sc.hasNext(); i++) {
        String channel = sc.next();
        String tvProgram;
        tvProgram = sc.nextLine().trim();
        arr.add(new TV(channel,tvProgram));

        }
        return arr;
    }

    public static HashMap<String,ArrayList<String>> sumChannels (ArrayList<TV> tvArray){
        HashMap<String,ArrayList<String>> channels = new HashMap<>();
        for (TV tv : tvArray) {
            channels.putIfAbsent(tv.getTvChannel(),new ArrayList<>());
            channels.get(tv.getTvChannel()).add(tv.getTvProgram());
        }
        return channels;
    }

    public static  HashMap<String,ArrayList<String>> tvProgrammes(ArrayList<TV> tvArray){
        HashMap<String,ArrayList<String>> tvProgrammes = new HashMap<>();
        for (TV tv : tvArray) {
            tvProgrammes.putIfAbsent(tv.getTvProgram(),new ArrayList<>());
            tvProgrammes.get(tv.getTvProgram()).add(tv.getTvChannel());

        }
        return tvProgrammes;
    }

    public static int differentProgram(ArrayList<TV> tvArray, String channel){
        HashMap<String,ArrayList<String>> tvChannels = new HashMap<>(sumChannels(tvArray));
        int nrOfProgram = 0;
        nrOfProgram= tvChannels.get(channel).size();
        return nrOfProgram;
    }

    public static int nrOfChannelTheSelectedProgram (ArrayList<TV> tvArray,String program){
        HashMap<String,ArrayList<String>> tvProgram = new HashMap<>(tvProgrammes(tvArray));
        int nrOfChannel = 0;
        nrOfChannel =tvProgram.get(program).size();

        return nrOfChannel;
    }
    public static boolean isPlayedProgram (ArrayList<TV> tvArray,String channel, String program){
        HashMap<String,ArrayList<String>> tvChannels = new HashMap<>(sumChannels(tvArray));
        if (tvChannels.get(channel).contains(program)){
            return true;
        }
        return false;
    }

    public static String theMostPlayedProgram (ArrayList<TV> tvArray){
        HashMap<String,ArrayList<String>> tvProgram = new HashMap<>(tvProgrammes(tvArray));
        String programName = null;
        int nrOfChannel = 0;
        for (String s: tvProgram.keySet()) {
            if (tvProgram.get(s).size()>nrOfChannel){
                nrOfChannel = tvProgram.get(s).size();
                programName = s;
            }

        }
        return programName;
    }
    public static void nrOfDifferentProgramInChanels (ArrayList<TV> tvArray){
        HashMap<String,ArrayList<String>> tvChannels = new HashMap<>(sumChannels(tvArray));
        for (String s:tvChannels.keySet()) {
            System.out.println(s + ": " + tvChannels.get(s).size());

        }
    }
    public static String programInEveryChanel (ArrayList<TV> tvArray){
        HashMap<String,ArrayList<String>> tvChannels = new HashMap<>(sumChannels(tvArray));
        HashMap<String,ArrayList<String>> tvProgram = new HashMap<>(tvProgrammes(tvArray));
        String programName = null;
        for (String s:tvProgram.keySet() ) {
            if (tvProgram.get(s).size()== tvChannels.size()){
                programName = s;
            }

        }
        return programName;
    }
    public static String programInOneChanel (ArrayList<TV> tvArray){
        HashMap<String,ArrayList<String>> tvProgram = new HashMap<>(tvProgrammes(tvArray));
        String programName = null;
        for (String s: tvProgram.keySet() ) {
            if (tvProgram.get(s).size() ==1){
                programName=s;
            }

        }
        return programName;
    }
}
