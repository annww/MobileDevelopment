import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_state_manager/src/simple/get_state.dart';
import 'package:untitled/baitap/fruit/Fruit641Controllerextends.dart';
import 'package:badges/badges.dart' as badges;

class FruitApp641 extends StatelessWidget {
  const FruitApp641({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      initialBinding: Fruit641Bindings(),
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
        useMaterial3: true
      ),
      home: PageHomeFruit641(),
    );
  }
}


class PageHomeFruit641 extends StatelessWidget {
  const PageHomeFruit641({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text("Fruit Store NTU"),
        actions:[
          BuidCart(),
        SizedBox(width: 200, height: 200,)
        ]
      ),
      body: GetBuilder(
          init: Fruit641Controller.controller,
          id: 'fruits',
          builder:(controller) {
            return
              GridView.extent(
                maxCrossAxisExtent: 200,
                mainAxisSpacing: 5,
                crossAxisSpacing: 5,
                childAspectRatio: 0.8,
                children: controller.fruits.map(
                      (fruit) {
                    return Column(
                      children: [
                        Image.network(fruit.anh?? "No URL"),
                        Text(fruit.ten),
                        Text("${fruit.gia} vnd")
                      ],
                    );
                  },
                ).toList(),
              );
          }
      ),
    );
  }
}

Widget BuidCart() {
  return
    GestureDetector(
      // onTap: () => Get.to(const CatalogPageCart()),
      child: GetBuilder(
        id: "giohang",
        init: Fruit641Controller.controller,
        builder: (controller) {
          return badges.Badge(
            badgeContent: Text("3", style: TextStyle(color: Colors.white),),
            // showBadge: controller.SLMH_GioHang,
            child: Icon(Icons.add_shopping_cart_outlined, size: 35,),
          );
        },
      ),
    );
}
