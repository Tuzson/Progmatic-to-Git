package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSwipeMerge {
    ArrayList<User> users;
    ArrayList<Swipe> swipes;

    public UserSwipeMerge() throws FileNotFoundException {
        users =new ArrayList<>();
        swipes = new ArrayList<>();
        users = fillUpUsers();
        swipes = fillUpSwipes();
        mergeUsers(users,swipes);

    }

    public ArrayList<User> fillUpUsers() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Txt files/users.txt"));
        ArrayList<User> users = new ArrayList<>();
        while (sc.hasNextLine()){
            String[] data = sc.nextLine().split(",");
            users.add(new User(Integer.parseInt(data[0]),data[1],data[2],Integer.parseInt(data[3]),data[4],data[5]));
        }
        return users;
    }

    public ArrayList<Swipe> fillUpSwipes () throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Txt files/swipes.txt"));
        ArrayList<Swipe>swipes = new ArrayList<>();
        while (sc.hasNextLine()){
            String[] data = sc.nextLine().split(",");
            swipes.add(new Swipe(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2]));
        }
        return swipes;
    }

    public void mergeUsers (ArrayList<User> users, ArrayList<Swipe> swipes){
        for (User user : users) {
            for (Swipe swipe : swipes) {
                for (User user2 : users) {
                    if (user.getId() == swipe.getUserId()) {
                        if (swipe.getOtherUserId() == user2.getId()) {
                            if (swipe.getLikeOrNot().equals("LIKE")) {
                                user.getLikedUsers().add(user2);
                                user2.setNrOfLikeToGet(+1);
                            } else if (swipe.getLikeOrNot().equals("DISLIKE")) {
                                user.getDisLikedUsers().add(user2);
                                user2.setGetNrOfDisLikeToGet(+1);
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        return "UserSwipeMerge{" +
                "users=" + users +
                ", swipes=" + swipes +
                '}';
    }

    public String queenOfTinder (){
        int max= 0;
        String name = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getGender().equals("FEMALE")){
                if (users.get(i).getNrOfLikeToGet() > max){
                    max = users.get(i).getNrOfLikeToGet();
                    name = users.get(i).getName();
                }
            }
        }
        return name;
    }
    public String theMostPickyUser(){
        String name = null;
        int sum =0;
        double rate = 0;
        double nr = 1;

        for (User user : users) {
            sum = user.getLikedUsers().size() + user.getDisLikedUsers().size();
            if (sum != 0) {
                rate = user.getLikedUsers().size() / (double) sum;
                if (rate < nr && rate > 0) {
                    nr = rate;
                    name = user.getName();

                }
            }
            sum = 0;
            rate = 0;
        }
        return name;
    }

    public int nrOfDesperateUsers(){
        int counter = 0;

        for (User user : users) {
            if (user.getDisLikedUsers().size() == 0 && user.getLikedUsers().size() > 0) {
                counter++;
            }
        }
        return counter;
    }

    public int nrOfNonLikedUsers(){
        int counter = 0;
        for (User user : users){
            if (user.getNrOfLikeToGet() == 0){
                counter++;
            }
        }
        return counter;
    }
    public int nrOfMatch(){
    int counter = 0;
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (users.get(i).getId() == swipes.get(j).getOtherUserId() && swipes.get(i).getUserId() == users.get(j).getId()){
                    counter++;
               
                }
            }
        }
    return counter;
    }

    public boolean nonHeterosexualMatch(){
        for (int i = 0; i < users.size(); i++) {
            for (User user : users.get(i).getLikedUsers())
            if (users.get(i).getGender().equals("MALE")){
                if (users.get(i).getLikedUsers().contains(user.getGender())){
                    return true;

                }
            }
        }
        return false;
    }

}