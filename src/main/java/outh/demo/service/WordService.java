package outh.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import outh.demo.model.Word;
import outh.demo.model.WordCategory;
import outh.demo.model.jsonModel.JsonWord;
import outh.demo.repository.WordCategoryRepository;
import outh.demo.repository.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    private WordRepository wordRepository;
    private WordCategoryRepository wordCategoryRepository;

    @Autowired
    WordService(WordRepository wordRepository, WordCategoryRepository wordCategoryRepository) {
        this.wordRepository = wordRepository;
        this.wordCategoryRepository = wordCategoryRepository;
    }

    public boolean addWord(JsonWord wordAnaCategory) {

        //WordCategory wordCategory = wordCategoryRepository.findById((wordAnaCategory.getId_category());
        WordCategory wordCategory = new WordCategory();
        wordCategory.setNameCategory("filozofia");
        wordCategory.setIdCategory(1);
        wordCategoryRepository.save(wordCategory);

        Word word = new Word(wordAnaCategory.getWord(), wordAnaCategory.getDescription_word(), wordCategory);

        wordRepository.save(word);
        return true;
    }

    private boolean wordExist(JsonWord wordAnaCategory) {
        if (wordRepository.existsByWord(wordAnaCategory.getWord()))
            return true;
        return false;
    }


    public boolean addCategory(String category) {
        if (wordCategoryRepository.existsByNameCategory(category))
            return false;
        wordCategoryRepository.save(new WordCategory(category));
        return true;

    }

    public List<WordCategory> getAllCategories() {
        return wordCategoryRepository.findAll();
    }

    public List<Word> getCategoriesByCategories(List<Integer> cateogryListId) {
        List<Word> wordsSelected = new ArrayList<>();
        List<Word> allWordSelectedByCategories = new ArrayList<>();
        for (Integer idCategory : cateogryListId) {
            wordsSelected = wordRepository.findAllByWordCategory(idCategory);

           allWordSelectedByCategories.addAll(wordsSelected);
        }

        return allWordSelectedByCategories;
    }
}
