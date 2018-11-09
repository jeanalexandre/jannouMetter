package com.jannouMetter.bo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ask")
public class Ask {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "entitled")
    private String entitled;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizz_id", nullable = false)
    private Quizz quizz;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ask")
    private List<Anwser> answers = new ArrayList<>();

    @Column(name = "total_polling")
    private int total_polling;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    public List<Anwser> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Anwser> answers) {
        this.answers = answers;
    }

    public int getTotal_polling() {
        return total_polling;
    }

    public void setTotal_polling(int total_polling) {
        this.total_polling = total_polling;
    }
}
