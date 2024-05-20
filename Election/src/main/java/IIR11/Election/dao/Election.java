package IIR11.Election.dao.Entities;

import java.sql.Date;
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
public class Election {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idElection;
    Date dateDebut;
    Date dateFin;

    @OneToMany(mappedBy = "election", fetch = FetchType.LAZY)
    List<Vote> vote;


    @OneToMany(mappedBy = "elections")
    List<ResultatElection> resultatElection;
}

