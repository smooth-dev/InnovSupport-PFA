package ma.emsi.gestionAdherents.repository;

import java.util.List;

import ma.emsi.gestionAdherents.model.Adherent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdherentRepository extends JpaRepository<Adherent, Long> {

}
