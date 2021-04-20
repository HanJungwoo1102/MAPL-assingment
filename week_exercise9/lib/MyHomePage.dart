import 'package:flutter/material.dart';

const INITIAL_NAME = "hanjungwoo";
const INITIAL_EMAIL = 'wjddnv@g.skku.edu';

const PROFILE_IMAGES = [
  "assets/images/profile1.png",
  "assets/images/profile2.png",
  "assets/images/profile3.png",
  "assets/images/profile4.png",
  "assets/images/profile5.png",
];

const RIGHT_PASSWORD = "qwer1234";

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final nameTextFieldController = TextEditingController();
  final emailTextFieldController = TextEditingController();
  final passwordTextFieldController = TextEditingController();

  String _name = INITIAL_NAME;
  String _email = INITIAL_EMAIL;
  int _imageIndex = 0;

  void _changeName() {
    if (isRightPassword(passwordTextFieldController.text)) {
      setState(() {
        _name = nameTextFieldController.text;
      });
    }
  }

  void _changeEmail() {
    if (isRightPassword(passwordTextFieldController.text)) {
      setState(() {
        _email = emailTextFieldController.text;
      });
    }

  }

  void _changeImage() {
    if (isRightPassword(passwordTextFieldController.text)) {
      setState(() {
        _imageIndex = _imageIndex + 1 == PROFILE_IMAGES.length ? 0 : _imageIndex + 1;
      });
    }
  }

  bool isRightPassword(String password) {
    return RIGHT_PASSWORD == password;
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          // Column is also a layout widget. It takes a list of children and
          // arranges them vertically. By default, it sizes itself to fit its
          // children horizontally, and tries to be as tall as its parent.
          //
          // Invoke "debug painting" (press "p" in the console, choose the
          // "Toggle Debug Paint" action from the Flutter Inspector in Android
          // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
          // to see the wireframe for each widget.
          //
          // Column has various properties to control how it sizes itself and
          // how it positions its children. Here we use mainAxisAlignment to
          // center the children vertically; the main axis here is the vertical
          // axis because Columns are vertical (the cross axis would be
          // horizontal).
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Profile Image',
            ),
            Text(
              'Name: $_name',
            ),
            Text(
              'Email: $_email',
            ),
            SizedBox(
              height: 180,
              child: Image.asset(PROFILE_IMAGES[_imageIndex]),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                    'Change Name: '
                ),
                Container(
                  child: TextField(
                    controller: nameTextFieldController,
                  ),
                  width: 100,
                ),
                ElevatedButton(onPressed: _changeName, child: Text('Change Name'))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                    'Change Email: '
                ),
                Container(
                  child: TextField(
                    controller: emailTextFieldController,
                  ),
                  width: 100,
                ),
                ElevatedButton(onPressed: _changeEmail, child: Text('Change Email'))
              ],
            ),
            TextButton(onPressed: _changeImage, child: Text('Change Image')),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('password: '),
                Container(
                  child: TextField(
                    controller: passwordTextFieldController,
                    obscureText: true,
                    enableSuggestions: false,
                    autocorrect: false,
                  ),
                  width: 100,
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
