package entity;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class Reservation {

    private Long id;
    private String name;

    public Reservation(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
