package global.goit.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "from_planet_id")
    private Long fromPlanetId;

    @Column(name = "to_planet_id")
    private Long toPlanetId;
}