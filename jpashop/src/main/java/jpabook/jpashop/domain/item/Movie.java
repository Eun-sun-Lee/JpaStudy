package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorColumn("M")
@Getter @Setter
public class Movie extends Item{

    private String director;
    private String actor;
}
