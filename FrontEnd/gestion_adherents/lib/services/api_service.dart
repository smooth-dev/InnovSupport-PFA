import 'dart:convert';

import 'package:gestion_adherents/models/adherents.dart';
import 'package:http/http.dart';

class ApiService {
  final String apiUrl = "http://192.168.0.7:3000/api";

  Future<List<Adherents>> getCases() async {
    Response res = await get(apiUrl);

    if (res.statusCode == 200) {
      List<dynamic> body = jsonDecode(res.body);
      List<Adherents> cases = body.map((dynamic item) => Adherents.fromJson(item)).toList();
      return cases;
    } else {
      throw "Failed to load cases list";
    }
  }

  Future<Adherents> getCaseById(String id) async {
    final response = await get('$apiUrl/$id');

    if (response.statusCode == 200) {
      return Adherents.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to load a case');
    }
  }

  Future<Adherents> createCase(Adherents adherent) async {
    Map data = {
      'nomSociete': adherent.nomSociete,
      'affiliation': adherent.affiliation,
      'denomination': adherent.denomination,
      'nomDirigeant': adherent.nomDirigeant,
      'representeur': adherent.representeur,
      'fonction': adherent.fonction,
      'gsm': adherent.gsm,
      'email': adherent.email,
      'adresse': adherent.adresse,
      'codePostal': adherent.codePostal,
      'ville': adherent.ville,
      'pays': adherent.pays,
      'telephone': adherent.telephone,
      'fax': adherent.fax,
      'siteWeb': adherent.siteWeb
    };

    final Response response = await post(
      apiUrl,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(data),
    );
    if (response.statusCode == 200) {
      return Adherents.fromJson(json.decode(response.body));
    } else {
      throw Exception('echec durant l\'ajout d\'adherent');
    }
  }

  Future<Adherents> updateCases(String id, Adherents adherent) async {
    Map data = {
      'nomSociete': adherent.nomSociete,
      'affiliation': adherent.affiliation,
      'denomination': adherent.denomination,
      'nomDirigeant': adherent.nomDirigeant,
      'representeur': adherent.representeur,
      'fonction': adherent.fonction,
      'gsm': adherent.gsm,
      'email': adherent.email,
      'adresse': adherent.adresse,
      'codePostal': adherent.codePostal,
      'ville': adherent.ville,
      'pays': adherent.pays,
      'telephone': adherent.telephone,
      'fax': adherent.fax,
      'siteWeb': adherent.siteWeb
    };

    final Response response = await put(
      '$apiUrl/$id',
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(data),
    );
    if (response.statusCode == 200) {
      return Adherents.fromJson(json.decode(response.body));
    } else {
      throw Exception('Echec de mise a jour d\'adherent');
    }
  }

  Future<void> deleteCase(String id) async {
    Response res = await delete('$apiUrl/$id');

    if (res.statusCode == 200) {
      print("Case deleted");
    } else {
      throw "Failed to delete a case.";
    }
  }

}