package ma.emsi.gestionAdherents.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ma.emsi.gestionAdherents.domaine.AdherentConverter;
import ma.emsi.gestionAdherents.domaine.AdherentVo;
import ma.emsi.gestionAdherents.exception.RecordNotFoundException;
import ma.emsi.gestionAdherents.model.Adherent;
import ma.emsi.gestionAdherents.repository.AdherentRepository;

@Service
public class AdherentsService 
{
	 @Autowired
	    AdherentRepository repository;
	 
	 public List<AdherentVo> getAllAdherents()
	    {
	        List<AdherentVo> articleList = AdherentConverter.toVoList(repository.findAll());
	         
	        if(articleList.size() > 0) {
	            return articleList;
	        } else {
	            return new ArrayList<AdherentVo>();
	        }
	    }
//	 public Adherent getAdherentById(Integer id) throws RecordNotFoundException
//	    {
//	        Optional<Adherent> article = repository.findById(id);
//	         
//	        if(article.isPresent()) {
//	            return article.get();
//	        } else {
//	            throw new RecordNotFoundException("No Adherent record exist for given id");
//	        }
//	    }
	 
	   public AdherentVo getAdherentById(Long id) {
			boolean trouve = repository.existsById(id);
			if (!trouve)
				return null;
			return AdherentConverter.toVo(repository.getOne(id));
		}
	 
	 public AdherentVo createOrUpdateAdherent(AdherentVo entity) throws RecordNotFoundException
	    {
	        Optional<Adherent> article = repository.findById(entity.getId());
	         
	        if(article.isPresent())
	        {
	            Adherent newEntity = article.get();
	    		newEntity.setNomSociete(entity.getNomSociete());
	    		newEntity.setAffiliation(entity.getAffiliation());
	    		newEntity.setDenomination(entity.getDenomination());
	    		newEntity.setNomDirigeant(entity.getNomDirigeant());
	    		newEntity.setRepresenteur(entity.getRepresenteur());
	    		newEntity.setFonction(entity.getFonction());
	    		newEntity.setGsm(entity.getGsm());
	    		newEntity.setEmail(entity.getEmail());
	    		newEntity.setAdresse(entity.getAdresse());
	    		newEntity.setCodePostal(entity.getCodePostal());
	    		newEntity.setVille(entity.getVille());
	    		newEntity.setPays(entity.getPays());
	    		newEntity.setTelephone(entity.getTelephone());
	    		newEntity.setFax(entity.getFax());
	    		newEntity.setSiteWeb(entity.getSiteWeb());

	 
	            newEntity = repository.save(newEntity);
	             
	            return entity;
	        } else {
	            repository.save(AdherentConverter.toBo(entity));
	            return entity;
	        }
	    }
	 
	 
	 public List<AdherentVo> getAllAdherents(int pageId, int size) {
			Page<Adherent> result = repository.findAll(PageRequest.of(pageId, size, Direction.ASC, "libelle"));
			return AdherentConverter.toVoList(result.getContent());
		}
	 
	 public List<AdherentVo> findByLibelle(String nomSociete) {
			List<Adherent> list = repository.findByNomSociete(nomSociete);
			return AdherentConverter.toVoList(list);
		}
	 public List<AdherentVo> sortBy(String fieldName) {
		 List<Adherent>  list =repository.findAll(Sort.by(fieldName));
			return AdherentConverter.toVoList(list);
	}
	 
		 
	 @Transactional
	    public Adherent save(Adherent entity) 
	    {
	       
	           return repository.save(entity);     
	        
	    }
	 

	  public void deleteAdherentById(Long id) throws RecordNotFoundException
	    {
	        Optional<Adherent> role = repository.findById(id);
	         
	        if(role.isPresent())
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No Adherent record exist for given id");
	        }
	    }
	  
	  @Transactional
		public void delete(Long id) {
			repository.deleteById(id);
		}
	  
	 @Transactional
		public void deleteAll() {
			repository.deleteAll();
		}
}