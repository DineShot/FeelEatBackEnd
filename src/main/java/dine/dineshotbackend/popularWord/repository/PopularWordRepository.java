package dine.dineshotbackend.popularWord.repository;

import dine.dineshotbackend.popularWord.entity.PopularWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularWordRepository extends JpaRepository<PopularWord, Long> {
}
