package outh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import outh.demo.model.Word;
import outh.demo.model.WordCategory;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    boolean existsByWord(String word);

    List<Word> findAllByWordCategory(WordCategory wordCategory);

    @Query(value = "Select * from world.word w where w.id_category = :id",
            nativeQuery = true)
    List<Word> findAllByWordCategory(@Param("id") int wordCategory);


}
