package dine.dineshotbackend.popularWord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "popular_search_word")
public class PopularWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "popular_search_word_code")
    private Long PopularWordCode;

    @Column(name = "popular_search_keyword")
    private String keyWord;

    @Column(name = "popular_search_date")
    private Date searchDate;

    public static PopularWord createPopualrWord(String name) {
        PopularWord popularWord = new PopularWord();
        popularWord.keyWord = name;
        popularWord.searchDate = new Date();
        return popularWord;
    }
}
