package ma.emsi.gestionAdherents.domaine;

import javax.persistence.*;


public class AdherentVo {


	private long id;

	private String nomSociete;

	private String affiliation;

	private String denomination;
	
	private String nomDirigeant;

	private String representeur;
	
	private String fonction;
	
	private String gsm;

	private String email;

	private String adresse;
	
	private String codePostal;

	private String ville;

	private String pays;
	
	private String telephone;
	
	private String fax;

	private String siteWeb;


	
	public AdherentVo() {

	}

	public AdherentVo(String nomSociete, String affiliation, String denomination, String nomDirigeant,
			String representeur, String fonction, String gsm, String email, String adresse, String codePostal,
			String ville, String pays, String telephone, String fax, String siteWeb) {
		this.nomSociete = nomSociete;
		this.affiliation = affiliation;
		this.denomination = denomination;
		this.nomDirigeant = nomDirigeant;
		this.representeur = representeur;
		this.fonction = fonction;
		this.gsm = gsm;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.telephone = telephone;
		this.fax = fax;
		this.siteWeb = siteWeb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getNomDirigeant() {
		return nomDirigeant;
	}

	public void setNomDirigeant(String nomDirigeant) {
		this.nomDirigeant = nomDirigeant;
	}

	public String getRepresenteur() {
		return representeur;
	}

	public void setRepresenteur(String representeur) {
		this.representeur = representeur;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}



	
	@Override
	public String toString() {
		return "Adherent [id=" + id + ", nomSociete=" + nomSociete + ", affiliation=" + affiliation + ", denomination="
				+ denomination + ", nomDirigeant=" + nomDirigeant + ", representeur=" + representeur + ", fonction="
				+ fonction + ", gsm=" + gsm + ", email=" + email + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + ", telephone=" + telephone + ", fax=" + fax + ", siteWeb="
				+ siteWeb + "]";
	}
}
