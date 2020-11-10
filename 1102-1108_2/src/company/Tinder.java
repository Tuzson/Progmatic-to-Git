package company;

import java.io.FileNotFoundException;

public class Tinder {

    public static void main(String[] args) throws FileNotFoundException {

        UserSwipeMerge tinder = new UserSwipeMerge();
        System.out.println(tinder);

        String queenOfTinder = tinder.queenOfTinder();
        System.out.println(queenOfTinder);
        String theMostPicky = tinder.theMostPickyUser();
        System.out.println(theMostPicky);
        int nrOfDesperateUsers = tinder.nrOfDesperateUsers();
        System.out.println(nrOfDesperateUsers);
        int nrOfNonLikedUsers = tinder.nrOfNonLikedUsers();
        System.out.println(nrOfNonLikedUsers);
        int nrOfMerge = tinder.nrOfMatch();
        System.out.println(nrOfMerge);
        boolean nonHeterosexual = tinder.nonHeterosexualMatch();
        System.out.println(nonHeterosexual);

    }
}
