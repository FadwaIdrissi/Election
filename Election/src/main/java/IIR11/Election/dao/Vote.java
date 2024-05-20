package IIR11.Election.dao.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVote;

    @ManyToOne
    Electeur electeur;
    @ManyToOne
    Election election;
    @ManyToOne
    Candidat candidat;


}