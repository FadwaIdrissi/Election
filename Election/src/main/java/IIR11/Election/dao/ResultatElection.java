package IIR11.Election.dao.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ResultatElection {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idResultatElection;
    int nbVote;

    @ManyToOne
    @JoinColumn(name = "idCandidat")
    private Candidat candidats;

    @ManyToOne
    @JoinColumn(name = "idElection")
    private Election elections;
}

