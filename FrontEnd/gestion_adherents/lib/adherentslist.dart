import 'package:flutter/material.dart';
import 'package:gestion_adherents/models/adherents.dart';
import 'detailwidget.dart';

class AdherentsList extends StatelessWidget {
  final List<Adherents> adherents;
  AdherentsList({Key key, this.adherents}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return
      ListView.builder(
          itemCount: adherents == null ? 0 : adherents.length,
          itemBuilder: (BuildContext context, int index) {
            return
              Card(
                  child: InkWell(
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => DetailWidget(adherents[index])),
                      );
                    },
                    child: ListTile(
                      leading: Icon(Icons.person),
                      title: Text(adherents[index].nomSociete),
                      subtitle: Text(adherents[index].representeur.toString()),
                    ),
                  )
              );
          });
  }
}