package com.jannouMetter;

import com.jannouMetter.bo.Quizz;
import com.jannouMetter.dao.QuizzRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuizzRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private QuizzRepository quizzRepository;

    @Test
    public void whenFindById_thenReturnQuizz() {
        //given
        Quizz given = new Quizz();
        given.setName("Test");
        Quizz anotherGiven = new Quizz();
        anotherGiven.setName("Test");
        entityManager.persist(given);
        entityManager.flush();

        //when
        Optional<Quizz> found = quizzRepository.findById(given.getId());

        //then
        Assert.assertTrue(found.isPresent());
        Assert.assertNotEquals(anotherGiven.getId(), found.get().getId());
        Assert.assertEquals(given.getId(), found.get().getId());
    }

    @Test
    public void whenFindAll_thenReturnList() {
        //given
        Quizz given = new Quizz();
        given.setName("Test");
        Quizz anotherGiven = new Quizz();
        anotherGiven.setName("Test");
        entityManager.persist(given);
        entityManager.persist(anotherGiven);
        entityManager.flush();

        //when
        List<Quizz> found = quizzRepository.findAll();

        //then
        Assert.assertFalse(found.isEmpty());
        Assert.assertTrue(found.contains(given));
    }

    @Test
    public void whenCreateQuizz_QuizzIsFound(){
        //given
        Quizz given = new Quizz();
        given.setName("Test");
        Quizz anotherGiven = new Quizz();
        anotherGiven.setName("Test");

        //when
        Quizz quizz = quizzRepository.save(given);
        Optional<Quizz>  found = quizzRepository.findById(given.getId());

        //then
        Assert.assertTrue(found.isPresent());
        Assert.assertNotEquals(anotherGiven.getId(), found.get().getId());
        Assert.assertEquals(given.getId(), found.get().getId());
    }
}
