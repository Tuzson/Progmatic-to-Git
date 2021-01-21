package com.company.PrisonerDilemma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrejudicedTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void PrejudicedGuyShouldBetrayIfTheSuspectsWhoAreNotCooperateWithHimLargerThanTheCooperatedList(){
        Prejudiced prejudiced = new Prejudiced();
        BadGuy badGuy = new BadGuy();
        BadGuy badGuy2 = new BadGuy();
        BadGuy badGuy3 = new BadGuy();
        Naive naive = new Naive();
        prejudiced.confess(badGuy);
        prejudiced.setPunishment(badGuy,2);
        badGuy.setPunishment(prejudiced,2);
        prejudiced.confess(badGuy2);
        prejudiced.setPunishment(badGuy2,2);
        prejudiced.setPunishment(naive,0);

        boolean betray = prejudiced.confess(badGuy3);
        assertTrue(betray);
    }
    @Test
    public void PrejudicedGuyShouldNotBetrayIfTheListOfCooperateLargerThanTheNonCooperatedList(){
        Prejudiced prejudiced = new Prejudiced();
        Naive naive = new Naive();
        Naive naive1 = new Naive();
        Naive naive2 = new Naive();
        BadGuy badGuy = new BadGuy();
        prejudiced.setPunishment(naive,0);
        prejudiced.setPunishment(naive1,0);
        prejudiced.setPunishment(badGuy,3);
        boolean betray = prejudiced.confess(naive2);
        assertFalse(betray);
    }

}