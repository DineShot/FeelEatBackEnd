package dine.dineshotbackend.popularWord.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPopularWord is a Querydsl query type for PopularWord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPopularWord extends EntityPathBase<PopularWord> {

    private static final long serialVersionUID = 1484511589L;

    public static final QPopularWord popularWord = new QPopularWord("popularWord");

    public final StringPath keyWord = createString("keyWord");

    public final NumberPath<Long> PopularWordCode = createNumber("PopularWordCode", Long.class);

    public final DateTimePath<java.util.Date> searchDate = createDateTime("searchDate", java.util.Date.class);

    public QPopularWord(String variable) {
        super(PopularWord.class, forVariable(variable));
    }

    public QPopularWord(Path<? extends PopularWord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPopularWord(PathMetadata metadata) {
        super(PopularWord.class, metadata);
    }

}

