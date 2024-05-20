package IIR11.Election.dao.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Electeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nomElecteur;
    String prenomElecteur;
    String cinElecteur;
    String emailElecteur;
    String passwordElecteur;

    @OneToMany(mappedBy = "electeur", fetch = FetchType.LAZY)
    List<Vote> vote;
}