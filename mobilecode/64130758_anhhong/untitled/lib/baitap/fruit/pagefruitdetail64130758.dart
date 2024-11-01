import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get_state_manager/src/simple/get_state.dart';
import 'package:untitled/baitap/fruit/models64130758_datafruit.dart';
import 'package:untitled/baitap/fruit/page_home_fruit64130758.dart';

import 'Fruit641Controllerextends.dart';
import 'package:flutter/material.dart';

class PageFruitDetail641 extends StatelessWidget {
  Fruit641 fruit;

  PageFruitDetail641({
    required this.fruit,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Chi tiết đơn hàng"),
        backgroundColor: Theme
            .of(context)
            .colorScheme
            .inversePrimary,
        actions: [
          BuidCart(),
          SizedBox(width: 20,)
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.only(top: 5),
        child: Column(
          children: [
            Container(
              width: MediaQuery
                  .of(context)
                  .size
                  .width * 0.9,
              height: MediaQuery
                  .of(context)
                  .size
                  .width * 0.9,
              child:
              Image.network(fruit.anh ?? "No URL"),
            ),
            Text("Bưởi")
          ],
        ),
      ),
    );
  }
}