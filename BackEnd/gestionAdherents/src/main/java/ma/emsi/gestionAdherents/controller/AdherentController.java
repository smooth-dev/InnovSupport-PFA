package ma.emsi.gestionAdherents.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.gestionAdherents.model.Adherent;
import ma.emsi.gestionAdherents.repository.AdherentRepository;;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class AdherentController {
	
	@Autowired
	AdherentRepository adherentRepository;
	
	@GetMapping("/adherents")
	  public ResponseEntity<List<Adherent>> getAllAdherents() {
	    try {
	      List<Adherent> adherents = new ArrayList<Adherent>();

	      adherentRepository.findAll().forEach(adherents::add);
	      
	      if (adherents.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(adherents, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/adherents/{id}")
	  public ResponseEntity<Adherent> getAdherentById(@PathVariable("id") long id) {
	    Optional<Adherent> adherentData = adherentRepository.findById(id);

	    if (adherentData.isPresent()) {
	      return new ResponseEntity<>(adherentData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/adherents")
	  public ResponseEntity<Adherent> createAdherent(@RequestBody Adherent adherent) {
	    try {
	      Adherent _adherent = adherentRepository
	          .save(new Adherent(adherent.getNomSociete(), adherent.getAffiliation(), adherent.getDenomination(), adherent.getNomDirigeant(),
	        		  adherent.getRepresenteur(),
	        		  adherent.getFonction(), adherent.getGsm(), adherent.getEmail(), adherent.getAdresse(), adherent.getCodePostal(),
	        		  adherent.getVille(), adherent.getPays(), adherent.getTelephone(), adherent.getFax(), adherent.getSiteWeb() ));
	      return new ResponseEntity<>(_adherent, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/adherents/{id}")
	  public ResponseEntity<Adherent> updateAdherent(@PathVariable("id") long id, @RequestBody Adherent adherent) {
	    Optional<Adherent> adherentData = adherentRepository.findById(id);

	    if (adherentData.isPresent()) {
	      Adherent _adherent = adherentData.get();
	      _adherent.setNomSociete(adherent.getNomDirigeant());
	      _adherent.setAffiliation(adherent.getAffiliation());
	      _adherent.setDenomination(adherent.getDenomination());
	      _adherent.setNomDirigeant(adherent.getNomDirigeant());
	      _adherent.setRepresenteur(adherent.getRepresenteur());
	      _adherent.setFonction(adherent.getFonction());
	      _adherent.setGsm(adherent.getGsm());
	      _adherent.setEmail(adherent.getEmail());
	      _adherent.setAdresse(adherent.getAdresse());
	      _adherent.setCodePostal(adherent.getCodePostal());
	      _adherent.setVille(adherent.getVille());
	      _adherent.setPays(adherent.getPays());
	      _adherent.setTelephone(adherent.getTelephone());
	      _adherent.setFax(adherent.getFax());
	      _adherent.setSiteWeb(adherent.getSiteWeb());
	      
	      

	      return new ResponseEntity<>(adherentRepository.save(_adherent), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/Adherents/{id}")
	  public ResponseEntity<HttpStatus> deleteAdherent(@PathVariable("id") long id) {
	    try {
	      adherentRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
