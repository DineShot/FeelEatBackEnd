package dine.dineshotbackend.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = -595728229L;

    public static final QMenu menu = new QMenu("menu");

    public final NumberPath<Long> menuCode = createNumber("menuCode", Long.class);

    public final NumberPath<Integer> menuDiscountRate = createNumber("menuDiscountRate", Integer.class);

    public final StringPath menuExplain = createString("menuExplain");

    public final BooleanPath menuIsAdult = createBoolean("menuIsAdult");

    public final BooleanPath menuIsSell = createBoolean("menuIsSell");

    public final StringPath menuName = createString("menuName");

    public final StringPath menuPhotoChange = createString("menuPhotoChange");

    public final NumberPath<Integer> menuPrice = createNumber("menuPrice", Integer.class);

    public final NumberPath<Long> restaurant = createNumber("restaurant", Long.class);

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

