import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:week_assignment_13/AccelerometerEvent.dart';

const eventChannel = const EventChannel("com.example/Accel");

Stream<AccelerometerEvent> _accelerometerEvents;

Stream<AccelerometerEvent> get accelerometerEventStream {
  Stream<AccelerometerEvent> accelerometerEvents = _accelerometerEvents;

  if (accelerometerEvents == null) {
    accelerometerEvents = eventChannel.receiveBroadcastStream().map(
            (dynamic event) => AccelerometerEvent(
                event[0] as double,
                event[1] as double,
                event[2] as double,
            )
    );
  }

  return accelerometerEvents;
}

class HomePage extends StatefulWidget {
  HomePage({Key key}) : super(key: key);
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  String _batteryLevel = "default";
  List<String> _accelerometerValues;
  StreamSubscription<dynamic> _streamSubscription;

  static const platform = const MethodChannel('com.example/Battery');

  Future<void> _getBatteryLevel() async {
    final int result = await platform.invokeMethod('getBatteryLevel');

    setState(() {
      _batteryLevel = 'Battery level is $result %.';
    });
  }

  @override
  void initState() {
    super.initState();

    _streamSubscription = accelerometerEventStream.listen((AccelerometerEvent event) {
      setState(() {
        _accelerometerValues = <String>[
          event.x.toStringAsFixed(3),
          event.y.toStringAsFixed(3),
          event.z.toStringAsFixed(3),
        ];
      });
    });
  }


  @override
  void dispose() {
    super.dispose();
    _streamSubscription.cancel();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Week Assignment 13'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text('Accelerometer Value is $_accelerometerValues'),
            Text('$_batteryLevel'),
            ElevatedButton(onPressed: _getBatteryLevel, child: Text('get battery level'))
          ],
        ),
      ),
    );
  }
}
