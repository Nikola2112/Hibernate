package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "planet_id")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;
    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Planet() {
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}