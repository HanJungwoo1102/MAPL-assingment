import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:week11_assignment/PagePath.dart';
import 'package:week11_assignment/PageVisitingCounterProvider.dart';

class HomePage extends StatefulWidget {
  HomePage({ Key key }) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  void onPressedMovePageButton(String pagePath, PageVisitingCounterProvider counter) {
    Navigator.pushNamed(context, pagePath);
    counter.increase(pagePath);
  }

  @override
  Widget build(BuildContext context) {
    PageVisitingCounterProvider counter = Provider.of<PageVisitingCounterProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text("Week10 Assignment"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(onPressed: () => onPressedMovePageButton(PAGE1_PAGE_PATH, counter), child: Text("Move To Page1")),
            ElevatedButton(onPressed: () => onPressedMovePageButton(PAGE2_PAGE_PATH, counter), child: Text("Move To Page2")),
            ElevatedButton(onPressed: () => onPressedMovePageButton(PAGE3_PAGE_PATH, counter), child: Text("Move To Page3")),
            ElevatedButton(onPressed: () => onPressedMovePageButton(PAGE4_PAGE_PATH, counter), child: Text("Move To Page4")),
            Consumer<PageVisitingCounterProvider>(
              builder: (context, counter, child) => Text(
                'Page1 Count: ${counter.getPageVisitingCount(PAGE1_PAGE_PATH)}\n'
                + 'Page2 Count: ${counter.getPageVisitingCount(PAGE2_PAGE_PATH)}\n'
                + 'page3 Count: ${counter.getPageVisitingCount(PAGE3_PAGE_PATH)}\n'
                + 'page4 Count: ${counter.getPageVisitingCount(PAGE4_PAGE_PATH)}'
              )
            )
          ],
        ),
      ),
    );
  }
}
