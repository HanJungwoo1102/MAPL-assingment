import 'package:flutter/material.dart';

class Page4Page extends StatefulWidget {
  Page4Page({ Key key }) : super(key: key);

  @override
  _Page4PageState createState() => _Page4PageState();
}

class _Page4PageState extends State<Page4Page> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Page 4"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
          ],
        ),
      ),
    );
  }
}
