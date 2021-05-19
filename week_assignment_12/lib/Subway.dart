import 'dart:developer' as developer;
class Subway {
  final int rowNum;
  final String subwayId;
  final String trainLineNm;
  final String subwayHeading;
  final String arvlMsg2;

  Subway({ this.subwayId, this.rowNum, this.trainLineNm, this.subwayHeading, this.arvlMsg2 });

  factory Subway.fromJson(Map<String, dynamic> json) {
    return Subway(
      rowNum: json['rowNum'],
      subwayId: json['subwayId'],
      trainLineNm: json['trainLineNm'],
      subwayHeading: json['subwayHeading'],
      arvlMsg2: json['arvlMsg2'],
    );
  }
}
