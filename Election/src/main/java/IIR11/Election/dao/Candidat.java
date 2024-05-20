package IIR11.Election.dao.Entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCandidat;
    String nomCandidat;
    String prenomCandidat;
    String description;
    String photoCandidat;

    @OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY)
    List<Vote> vote;

    @OneToMany(mappedBy = "candidats")
    List<ResultatElection> resultatCandidat;

}
