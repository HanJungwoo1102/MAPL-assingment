import 'dart:convert';
import 'dart:developer' as developer;
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:week_assignment_12/Subway.dart';

class HomePage extends StatefulWidget {
  HomePage({Key key }) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  Future<Subway> subway;

  @override
  void initState() {
    super.initState();

    subway = fetchSubway();
  }

  Future<Subway> fetchSubway() async {
    String API_KEY = 'sample';
    Uri apiUrl = Uri.parse('http://swopenAPI.seoul.go.kr/api/subway/${API_KEY}/json/realtimeStationArrival/0/5/성균관대');

    var response;

    try {
      response = await http.get(apiUrl);
    } catch (exception) {
      throw Exception('Failed to load subway');
    }

    if (response.statusCode == 200) {
      final decodedJson = json.decode(response.body);
      try {
        return Subway.fromJson(decodedJson['realtimeArrivalList'][0]);
      } catch (e) {
        developer.log("error: ${e}");
      }
    }

    throw Exception('Failed to load subway');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Week Assignment 12"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            FutureBuilder<Subway>(
              future: subway,
              builder: (context, snapshot) {
                if (snapshot.hasData) {
                  return Text(''
                    'rowNum: ${snapshot.data.rowNum}\n'
                    'subwayId: ${snapshot.data.subwayId}\n'
                    'trainLineNm: ${snapshot.data.trainLineNm}\n'
                    'subwayHeading: ${snapshot.data.subwayHeading}\n'
                    'arvlMsg2: ${snapshot.data.arvlMsg2}\n'
                  );
                } else if (snapshot.hasError) {
                  return Text("fetch 에 실패했습니다.");
                }

                return CircularProgressIndicator();
              },
            ),
          ],
        ),
      ),
    );
  }
}
