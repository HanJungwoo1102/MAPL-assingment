import 'package:flutter/material.dart';

class Page1Page extends StatefulWidget {
  Page1Page({ Key key }) : super(key: key);

  @override
  _Page1PageState createState() => _Page1PageState();
}

class _Page1PageState extends State<Page1Page> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Page 1"),
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
