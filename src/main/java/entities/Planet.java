package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    private String id;

    public void setId(String id) {
        if (id.matches("^[A-Z0-9]+$")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid planet ID format.");
        }
    }

    @Column
    private String name;

    public void setName(String name) {
        if (name.length() >= 1 && name.length() <= 500) {
        this.name = name;
    } else {
        throw new IllegalArgumentException("Name length must be between 3 and 200 characters.");
    }
}
}
