import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:async';
import 'dart:convert';
import 'package:week_assignment_14/Photo.dart';
import 'dart:developer' as developer;

Future<List<Photo>> fetchPhotos(http.Client client, int size) async {
  final response = await client.get(Uri.parse('https://jsonplaceholder.typicode.com/photos'));
  return parsePhotos(response.body).sublist(0, size);
}

List<Photo> parsePhotos(String responseBody) {
  final parsed = json.decode(responseBody).cast<Map<String, dynamic>>();

  return parsed.map<Photo>((json) => Photo.fromJson(json)).toList();
}

class HomePage extends StatefulWidget {
  HomePage({Key key }) : super(key: key);

  @override
  State<StatefulWidget> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int clickCount = 0;
  Future<List<Photo>> futureListPhoto;

  void onPressed() {
    final newClickCount = clickCount + 1;
    futureListPhoto = fetchPhotos(http.Client(), newClickCount * newClickCount);
    setState(() {
      clickCount = newClickCount;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Week Assignment 14"),
      ),
      body: Column(
        children: [
          Center(
            child: TextButton(
              onPressed: onPressed,
              child: Text("Http request button: $clickCount clicked"),
            )
          ),
          clickCount > 0
            ? FutureBuilder<List<Photo>>(
              future: futureListPhoto,
              builder: (context, snapshot) {
                if (snapshot.hasError) print(snapshot.data);

                return snapshot.hasData
                    ? Expanded(child: PhotoList(photos: snapshot.data))
                    : Center(child: CircularProgressIndicator());
              },
            ) : Container()
        ]
      )
    );
  }
}

class PhotoList extends StatelessWidget {
  final List<Photo> photos;

  PhotoList({ Key key, this.photos }): super(key: key);

  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
      ),
      itemCount: photos.length,
      itemBuilder: (context, index) {
        return Image.network(photos[index].thumbnailUrl);
      },
    );
  }
}