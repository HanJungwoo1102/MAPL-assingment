import 'package:flutter/material.dart';
import 'package:week10_assignment/HomePage.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Week Assignment 10',
      theme: ThemeData.light(),
      darkTheme: ThemeData(
        brightness: Brightness.dark,
      ),
      themeMode: ThemeMode.dark,
      home: HomePage(title: 'Week Assignment 10'),
    );
  }
}

