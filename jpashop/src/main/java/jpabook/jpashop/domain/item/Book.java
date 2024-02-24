package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorColumn("B") // single table이므로 DB에서 구분 가능해야함. 기본으로 두면 Book으로 들어감.
@Getter @Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
