package ma.emsi.gestionAdherents.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.emsi.gestionAdherents.model.Adherent;


@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {

	List<Adherent> findByNomSociete(String nomSociete);

}
