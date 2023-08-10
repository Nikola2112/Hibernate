package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    private long id;

    @Column
    private String name;
    public void setName(String name) {
        if (name.length() >= 3 && name.length() <= 200) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name length must be between 3 and 200 characters.");
        }
    }
}





