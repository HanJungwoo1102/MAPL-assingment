import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  HomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final textController = TextEditingController();
  String _text = "";
  List<String> _texts = [];

  void _addText() {
    setState(() {
      _texts = [..._texts, textController.text];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Container(
        padding: EdgeInsets.all(12),
        child: Column(
          children: [
            Row(
              children: [
                Expanded(
                  child: Container(
                    child: TextField(
                      controller: textController,
                      decoration: InputDecoration(
                        border: new OutlineInputBorder(),
                      ),
                    ),
                    width: 280,
                  ),
                ),
                Container(
                  padding: EdgeInsets.only(left: 8),
                  child: ElevatedButton(
                    onPressed: _addText,
                    child: Text('Put'),
                  ),
                ),
              ],
            ),
            Padding(padding: EdgeInsets.only(top: 8)),
            Expanded(
              child: Container(
                child: ListView.builder(
                    scrollDirection: Axis.vertical,
                    itemCount: _texts.length,
                    itemBuilder: (BuildContext _ctx, int i) {
                      return ListTile(
                        title: Text(
                          _texts[i],
                        ),
                      );
                    }
                ),
              )
            ),
          ],
        ),
      )
    );
  }
}
