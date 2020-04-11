package outh.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import outh.demo.model.WordCategory;

import java.util.List;

@Repository
public interface WordCategoryRepository extends CrudRepository<WordCategory, Long> {
    boolean existsByNameCategory(String name_category);

    List<WordCategory> findAll();

    //WordCategory getWordCategoriesByIdCategory(Integer idCategory);
    WordCategory getWordCategoryByIdCategory(Long idCategory);


}
