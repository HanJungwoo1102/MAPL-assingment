import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:week11_assignment/HomePage.dart';
import 'package:week11_assignment/Page1Page.dart';
import 'package:week11_assignment/Page2Page.dart';
import 'package:week11_assignment/Page3Page.dart';
import 'package:week11_assignment/Page4Page.dart';
import 'package:week11_assignment/PageVisitingCounterProvider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (context) => PageVisitingCounterProvider())
      ],
      child: MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        routes: {
          '/': (context) => HomePage(),
          '/page1': (context) => Page1Page(),
          '/page2': (context) => Page2Page(),
          '/page3': (context) => Page3Page(),
          '/page4': (context) => Page4Page(),
        },
      )
    );
  }
}
