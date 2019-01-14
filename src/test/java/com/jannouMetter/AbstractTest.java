package com.jannouMetter;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.dao.AnswerRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JannouMetterApplication.class, webEnvironment = DEFINED_PORT)
public abstract class AbstractTest {

    /**
     * Number of object to persist in test.
     */
    public static final int MAX_ELEMENT = 200;

    /**
     *
     */
    protected MockMvc mockMvc;


    /**
     *
     */
    @Autowired
    protected RestTemplate restTemplate;

    /**
     *
     */
    @Autowired
    protected WebApplicationContext webApplicationContext;

    /**
     * Repository used to persist Packager Object
     */
    @Autowired
    protected AnswerRepository answerRepository;

    /**
     * Contain the packager object persisted for the test
     */
    protected List<Answer> list;

    /**
     * A packager having the same property of the first saved.
     */
    protected Answer doublon;

    /**
     *
     */
    protected String baseUrl;

    /**
     *
     */
    @LocalServerPort
    int serverPort;

    /**
     * Initialization method.
     */
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        this.baseUrl = "http://localhost:" + this.serverPort;

        list = answerRepository.saveAll(
                IntStream
                        .rangeClosed(0, MAX_ELEMENT - 1)
                        .mapToObj(i -> {
                            Answer newAnswer = new Answer();
                            newAnswer.setEntitled("Answer "+i);
                            return newAnswer;
                        })
                        .collect(Collectors.toList()));

        Answer first = list.get(0);
        doublon = list.get(MAX_ELEMENT - 1);
        doublon.setId(first.getId());
        doublon.setEntitled(first.getEntitled());

        answerRepository.save(doublon);
    }


}