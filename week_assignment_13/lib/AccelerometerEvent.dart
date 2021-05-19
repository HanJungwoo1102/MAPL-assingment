class AccelerometerEvent {
  final double x;
  final double y;
  final double z;

  AccelerometerEvent(this.x, this.y, this.z);

  @override
  String toString() => 'AccelerometerEvent ( x: $x y: $y z: $z )';
}