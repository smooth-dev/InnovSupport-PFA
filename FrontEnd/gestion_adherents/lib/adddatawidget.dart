import 'package:flutter/material.dart';
import 'package:gestion_adherents/services/api_service.dart';
import 'models/adherents.dart';

enum Affiliation { Oui, Non }

class AddDataWidget extends StatefulWidget {
  AddDataWidget();

  @override
  _AddDataWidgetState createState() => _AddDataWidgetState();
}

class _AddDataWidgetState extends State<AddDataWidget> {
  _AddDataWidgetState();

  final ApiService api = ApiService();
  final _addFormKey = GlobalKey<FormState>();
  final _nomSocieteController = TextEditingController();
  final _denominationController = TextEditingController();
  final _nomDirigeantController = TextEditingController();
  String affiliation = 'Oui';
  Affiliation _affiliation = Affiliation.Oui;
  final _representeurController = TextEditingController();
  final _fonctionController = TextEditingController();
  final _gsmController = TextEditingController();
  final _emailController = TextEditingController();
  final _adresseController = TextEditingController();
  final _codePostalController = TextEditingController();
  final _villeController = TextEditingController();
  final _paysController = TextEditingController();
  final _telephoneController = TextEditingController();
  final _faxController = TextEditingController();
  final _siteWebController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Add Cases'),
      ),
      body: Form(
        key: _addFormKey,
        child: SingleChildScrollView(
          child: Container(
            padding: EdgeInsets.all(20.0),
            child: Card(
                child: Container(
                    padding: EdgeInsets.all(10.0),
                    width: 440,
                    child: Column(
                      children: <Widget>[
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Nom de la societe:'),
                              TextFormField(
                                controller: _nomSocieteController,
                                decoration: const InputDecoration(
                                  hintText: 'Nom de la societe',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le nom de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Affiliation'),
                              ListTile(
                                title: const Text('Oui'),
                                leading: Radio(
                                  value: Affiliation.Oui,
                                  groupValue: _affiliation,
                                  onChanged: (Affiliation value) {
                                    setState(() {
                                      _affiliation = value;
                                      affiliation = 'Oui';
                                    });
                                  },
                                ),
                              ),
                              ListTile(
                                title: const Text('Non'),
                                leading: Radio(
                                  value: Affiliation.Non,
                                  groupValue: _affiliation,
                                  onChanged: (Affiliation value) {
                                    setState(() {
                                      _affiliation = value;
                                      affiliation = 'Non';
                                    });
                                  },
                                ),
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Denomination'),
                              TextFormField(
                                controller: _denominationController,
                                decoration: const InputDecoration(
                                  hintText: 'Denomination',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer la denomination de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Nom du dirigeant'),
                              TextFormField(
                                controller: _nomDirigeantController,
                                decoration: const InputDecoration(
                                  hintText: 'Nom du dirigeant',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le nom du dirigeant de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Representeur'),
                              TextFormField(
                                controller: _representeurController,
                                decoration: const InputDecoration(
                                  hintText: 'Representeur',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le representeur de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Fonction'),
                              TextFormField(
                                controller: _fonctionController,
                                decoration: const InputDecoration(
                                  hintText: 'Fonction',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer la fonction de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('GSM'),
                              TextFormField(
                                controller: _gsmController,
                                decoration: const InputDecoration(
                                  hintText: 'GSM',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le numero GSM';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('E-mail'),
                              TextFormField(
                                controller: _emailController,
                                decoration: const InputDecoration(
                                  hintText: 'email',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer l\'email de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Adresse'),
                              TextFormField(
                                controller: _adresseController,
                                decoration: const InputDecoration(
                                  hintText: 'Adresse',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer l\'adresse de votre societe';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Code Postal'),
                              TextFormField(
                                controller: _codePostalController,
                                decoration: const InputDecoration(
                                  hintText: 'Code Postal',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le code postal';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Ville'),
                              TextFormField(
                                controller: _villeController,
                                decoration: const InputDecoration(
                                  hintText: 'Ville',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer la ville';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Pays'),
                              TextFormField(
                                controller: _paysController,
                                decoration: const InputDecoration(
                                  hintText: 'Pays',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le pays';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Telephone'),
                              TextFormField(
                                controller: _telephoneController,
                                decoration: const InputDecoration(
                                  hintText: 'Telephone',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer le numero de telephone';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Fax'),
                              TextFormField(
                                controller: _faxController,
                                decoration: const InputDecoration(
                                  hintText: 'Fax',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez enter le numero du fax';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              Text('Site Web'),
                              TextFormField(
                                controller: _siteWebController,
                                decoration: const InputDecoration(
                                  hintText: 'Site Web',
                                ),
                                validator: (value) {
                                  if (value.isEmpty) {
                                    return 'Veuillez entrer l\'adresse du site web';
                                  }
                                  return null;
                                },
                                onChanged: (value) {},
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.fromLTRB(0, 0, 0, 10),
                          child: Column(
                            children: <Widget>[
                              RaisedButton(
                                splashColor: Colors.red,
                                onPressed: () {
                                  if (_addFormKey.currentState.validate()) {
                                    _addFormKey.currentState.save();
                                    api.createCase(Adherents(nomSociete: _nomSocieteController.text, affiliation: affiliation,
                                        denomination: _denominationController.text, nomDirigeant: _nomDirigeantController.text,
                                        representeur: _representeurController.text, fonction: _fonctionController.text,
                                        gsm: _gsmController.text, email: _emailController.text,
                                        adresse: _adresseController.text, codePostal: _codePostalController.text,
                                        ville: _villeController.text, pays: _paysController.text,
                                        telephone: _telephoneController.text, fax: _faxController.text,
                                        siteWeb: _siteWebController.text
                                        ));

                                    Navigator.pop(context) ;
                                  }
                                },
                                child: Text('Sauvegarder', style: TextStyle(color: Colors.white)),
                                color: Colors.blue,
                              )
                            ],
                          ),
                        ),
                      ],
                    )
                )
            ),
          ),
        ),
      ),
    );
  }
}