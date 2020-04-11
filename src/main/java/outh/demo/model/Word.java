package outh.demo.model;

import javax.persistence.*;

@Entity
public class Word  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idWord;

    private String word;
    private String description_word;


    @OneToOne
    @JoinColumn(name = "id_category")
    private WordCategory wordCategory;

    public Word() {
    }

    public Word(String word, String description_word, WordCategory wordCategory_) {
        this.word = word;
        this.description_word = description_word;
        this.wordCategory = wordCategory_;
    }


    public long getIdWord() {
        return idWord;
    }

    public void setIdWord(long id_word) {
        this.idWord = id_word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription_word() {
        return description_word;
    }

    public void setDescription_word(String description_word) {
        this.description_word = description_word;
    }

    public WordCategory getWordCategory() {
        return wordCategory;
    }

    public void setWordCategory(WordCategory wordCategory) {
        this.wordCategory = wordCategory;
    }

    @Override
    public String toString() {
        return "Word{" +
                "idWord=" + idWord +
                ", word='" + word + '\'' +
                ", description_word='" + description_word + '\'' +
                ", wordCategory=" + wordCategory +
                '}';
    }
}
