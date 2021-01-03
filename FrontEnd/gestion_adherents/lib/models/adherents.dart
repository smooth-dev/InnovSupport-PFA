class Adherents {
  final String id;
  final String nomSociete;
  final String affiliation;
  final String denomination;
  final String nomDirigeant;
  final String representeur;
  final String fonction;
  final String gsm;
  final String email;
  final String adresse;
  final String codePostal;
  final String ville;
  final String pays;
  final String telephone;
  final String fax;
  final String siteWeb;


  Adherents({ this.id, this.nomSociete, this.affiliation,
    this.denomination, this.nomDirigeant, this.representeur,
    this.fonction, this.gsm, this.email, this.adresse,
    this.codePostal, this.ville, this.pays,
    this.telephone, this.fax, this.siteWeb });

  factory Adherents.fromJson(Map<String, dynamic> json) {
    return Adherents(
        id: json['_id'] as String,
        nomSociete: json['nomSociete'] as String,
        affiliation: json['affiliation'] as String,
        denomination: json['denomination'] as String,
        nomDirigeant: json['nomDirigeant'] as String,
        representeur: json['representeur'] as String,
        fonction: json['fonction'] as String,
        gsm: json['gsm'] as String,
        email: json['email'] as String,
        adresse: json['adresse'] as String,
        codePostal: json['codePostal'] as String,
        ville: json['ville'] as String,
        pays: json['pays'] as String,
        telephone: json['telephone'] as String,
        fax: json['fax'] as String,
        siteWeb: json['siteWeb'] as String
    );
  }

  @override
  String toString() {
    return "Adherents{id: $id, nomSociete: $nomSociete,"
        " affiliation: $affiliation, denomination: $denomination,"
        " nomDirigeant: $nomDirigeant, representeur: $representeur,"
        " fonction: $fonction, gsm: $gsm, email: $email,"
        " adresse: $adresse, codePostal: $codePostal,"
        " ville: $ville, pays: $pays, telephone: $telephone,"
        " fax: $fax, siteWeb: $siteWeb}";
  }
}
