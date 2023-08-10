package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    private long id;
    @Column
    private LocalDateTime createdAt;
    @Column
    private long client_id;
    @Column
    private String from_planet_id;
    @Column
    private String to_planet_id;


}
