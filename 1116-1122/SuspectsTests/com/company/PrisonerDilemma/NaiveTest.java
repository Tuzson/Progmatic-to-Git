package com.company.PrisonerDilemma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NaiveTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void naiveGuyShouldAlwaysNotBetray(){
        Naive naive = new Naive();
        BadGuy badGuy = new BadGuy();
        boolean betray = naive.confess(badGuy);
        assertFalse(betray);
    }
}