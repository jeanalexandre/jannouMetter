package com.jannouMetter;


import com.jannouMetter.bo.Ask;
import com.jannouMetter.bo.Quizz;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class QuizzUnitTest {

    @Test
    public void suscribeTest(){
        //given
        Quizz testingQuizz = new Quizz();
        testingQuizz.setName("FUTURA QUIZZ");
        testingQuizz.setCurrentAsk(0);
        testingQuizz.setNbContributors(0);
        testingQuizz.setState("ToDo");
        List<Ask> asks = new ArrayList<>();
        testingQuizz.setAsks(asks);

        //when
        int nbContributorsBeforeSuscribe = testingQuizz.getNbContributors();
        for(int i=1; i<10; i++)
            testingQuizz.subscribe();
        int nbContributorsAfterSuscribe = testingQuizz.getNbContributors();

        //then
        assertTrue(nbContributorsBeforeSuscribe < nbContributorsAfterSuscribe);
    }

    @Test
    public void unsuscribeTest(){
        //given
        Quizz testingQuizz = new Quizz();
        testingQuizz.setName("FUTURA QUIZZ");
        testingQuizz.setCurrentAsk(0);
        testingQuizz.setNbContributors(30);
        testingQuizz.setState("ToDo");
        List<Ask> asks = new ArrayList<>();
        testingQuizz.setAsks(asks);

        //when
        int nbContributorsBeforeSuscribe = testingQuizz.getNbContributors();
        for(int i=1; i<10; i++)
            testingQuizz.unsubscribe();
        int nbContributorsAfterSuscribe = testingQuizz.getNbContributors();

        //then
        assertTrue(nbContributorsBeforeSuscribe > nbContributorsAfterSuscribe);
    }
}
