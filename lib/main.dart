import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const WebViewScreen(),
    );
  }
}

class WebViewScreen extends StatelessWidget {
  const WebViewScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(child: const _WebView()),
    );
  }
}

class _WebView extends StatelessWidget {
  const _WebView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // PlatformView for WebView
    return defaultTargetPlatform == TargetPlatform.android
        ? const AndroidView(
            viewType: 'native-webview',
            layoutDirection: TextDirection.ltr,
          )
        : const Center(
            child: Text('iOS WebView not implemented yet.'),
          );
  }
}
