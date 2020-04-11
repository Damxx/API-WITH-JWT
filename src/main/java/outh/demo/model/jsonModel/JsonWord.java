package outh.demo.model.jsonModel;

public class JsonWord {

    private String word;
    private String description_word;
    private int id_category;

    public JsonWord(String word, String description_word, int id_category) {
        this.word = word;
        this.description_word = description_word;
        this.id_category = id_category;
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

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    @Override
    public String toString() {
        return "JsonWord{" +
                "word='" + word + '\'' +
                ", description_word='" + description_word + '\'' +
                ", id_category=" + id_category +
                '}';
    }
}
