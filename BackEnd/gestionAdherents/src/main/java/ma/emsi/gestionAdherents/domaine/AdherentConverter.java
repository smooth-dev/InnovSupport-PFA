package ma.emsi.gestionAdherents.domaine;


import java.util.ArrayList;
import java.util.List;
import ma.emsi.gestionAdherents.model.Adherent;

public class AdherentConverter
{

	
	public static AdherentVo toVo(Adherent bo) {
		if (bo == null)
			return null;
		AdherentVo vo = new AdherentVo();
		vo.setId(bo.getId());
		vo.setNomSociete(bo.getNomSociete());
		vo.setAffiliation(bo.getAffiliation());
		vo.setDenomination(bo.getDenomination());
		vo.setNomDirigeant(bo.getNomDirigeant());
		vo.setRepresenteur(bo.getRepresenteur());
		vo.setFonction(bo.getFonction());
		vo.setGsm(bo.getGsm());
		vo.setEmail(bo.getEmail());
		vo.setAdresse(bo.getAdresse());
		vo.setCodePostal(bo.getCodePostal());
		vo.setVille(bo.getVille());
		vo.setPays(bo.getPays());
		vo.setTelephone(bo.getTelephone());
		vo.setFax(bo.getFax());
		vo.setSiteWeb(bo.getSiteWeb());
		
		//vo.setPanier(PanierConverter.toVo(bo.getPanier()));
	

		return vo;
	}

	public static Adherent toBo(AdherentVo vo) {
		if (vo == null)
			return null;
		Adherent bo = new Adherent();
		if (vo.getId() != null)
			bo.setId(vo.getId());
		bo.setNomSociete(vo.getNomSociete());
		bo.setAffiliation(vo.getAffiliation());
		bo.setDenomination(vo.getDenomination());
		bo.setNomDirigeant(vo.getNomDirigeant());
		bo.setRepresenteur(vo.getRepresenteur());
		bo.setFonction(vo.getFonction());
		bo.setGsm(vo.getGsm());
		bo.setEmail(vo.getEmail());
		bo.setAdresse(vo.getAdresse());
		bo.setCodePostal(vo.getCodePostal());
		bo.setVille(vo.getVille());
		bo.setPays(vo.getPays());
		bo.setTelephone(vo.getTelephone());
		bo.setFax(vo.getFax());
		bo.setSiteWeb(vo.getSiteWeb());

		//bo.setPanier(PanierConverter.toBo(vo.getPanier()));

		return bo;
	}

	public static List<AdherentVo> toVoList(List<Adherent> boList) {
		if (boList == null || boList.isEmpty())
			return null;
		List<AdherentVo> voList = new ArrayList<>();
		for (Adherent Adherent : boList) {
			voList.add(toVo(Adherent));
		}
		return voList;
	}

	public static List<Adherent> toBoList(List<AdherentVo> voList) {
		if (voList == null || voList.isEmpty())
			return null;
		List<Adherent> boList = new ArrayList<>();
		for (AdherentVo AdherentVo : voList) {
			boList.add(toBo(AdherentVo));
		}
		return boList;
	}
}
