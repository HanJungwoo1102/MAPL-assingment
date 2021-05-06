import 'package:flutter/material.dart';

class PageVisitingCounterProvider with ChangeNotifier {
  Map<String, int> counts = new Map<String, int>();

  PageVisitingCounterProvider();

  void increase(String pageKey) {
    if (this.counts[pageKey] == null) {
      this.counts[pageKey] = 0;
    }
    this.counts[pageKey] += 1;
    notifyListeners();
  }

  int getPageVisitingCount(String pageKey) {
    if (this.counts[pageKey] == null) {
      return 0;
    }
    return this.counts[pageKey];
  }
}