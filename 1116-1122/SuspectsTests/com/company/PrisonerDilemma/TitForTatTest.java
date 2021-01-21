package com.company.PrisonerDilemma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TitForTatTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void shouldCooperateIfMeetFirstTime(){
        TitForTat titGuy = new TitForTat();
        BadGuy badGuy = new BadGuy();
        boolean betray = titGuy.confess(badGuy);
        assertFalse(betray);

    }
@Test
    public void shouldBetrayIfOtherBetrayLastTime(){
        TitForTat toTest = new TitForTat();
        BadGuy badGuy = new BadGuy();
        toTest.confess(badGuy);
        toTest.setPunishment(badGuy,3);
        badGuy.setPunishment(toTest,0);
        boolean betray = toTest.confess(badGuy);
        assertTrue(betray);
    }
@Test
    public void shouldCooperateIfOtherCooperatedLastTime(){
        TitForTat titGuy = new TitForTat();
        Naive naive = new Naive();
        titGuy.confess(naive);
        titGuy.setPunishment(naive,0);
        naive.setPunishment(titGuy,0);
        boolean betray = titGuy.confess(naive);
        assertFalse(betray);

    }

}