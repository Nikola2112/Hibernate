package global.goit.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    public Ticket( Timestamp createdAt, Client client, Planet fromPlanetId, Planet toPlanetId) {
        this.createdAt = createdAt;
        this.client = client;
        this.fromPlanetId = fromPlanetId;
        this.toPlanetId = toPlanetId;
    }

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", referencedColumnName = "planet_id", nullable = false)
    private Planet fromPlanetId;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", referencedColumnName = "planet_id", nullable = false)
    private Planet toPlanetId;

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{createdAt=" + createdAt +
                ", client=" + client +
                ", fromPlanetId=" + fromPlanetId +
                ", toPlanetId=" + toPlanetId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Client getClient() {
        return client;
    }

    public Planet getFromPlanetId() {
        return fromPlanetId;
    }

    public Planet getToPlanetId() {
        return toPlanetId;
    }
}