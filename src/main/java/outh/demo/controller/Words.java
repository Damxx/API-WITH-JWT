package outh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import outh.demo.model.Word;
import outh.demo.model.WordCategory;
import outh.demo.model.jsonModel.JsonWord;
import outh.demo.service.WordService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Words {

    private WordService wordService;

    @Autowired
    Words(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/addWord")
    public boolean addWord(@RequestBody JsonWord jsonWord) {
        System.out.println(jsonWord);
        return wordService.addWord(jsonWord);
    }

    @GetMapping("/getListCategories/{page}")
    public ResponseEntity<List<WordCategory>> getAllCategories(@PathVariable("page") int page) {
        Page<WordCategory> pages = wordService.getAllWordCategoryPageable(page-1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<WordCategory> wordCategoryList = pages.getContent();

        List<WordCategory> wordCategory = wordService.getAllCategories();
        return ResponseEntity.ok(wordCategory);
    }

    @GetMapping("/getListCategoriesByPreference/{preferenceValues}")
    public ResponseEntity<List<Word>> getListCategoriesByPreference(@PathVariable String preferenceValues) {
        String[] valArr = preferenceValues.split(",");
        List<Integer> cateogryList = new ArrayList<>();
        for (String s : valArr) {
            cateogryList.add(new Integer(s));
        }
        List<Word> selectedWords = wordService.getCategoriesByCategories(cateogryList);
        return new ResponseEntity<List<Word>> (selectedWords, HttpStatus.OK);
    }

    @PostMapping("/addCategory/{category}")
    public boolean addCategory(@PathVariable String category) {
        return wordService.addCategory(category);
    }


}
