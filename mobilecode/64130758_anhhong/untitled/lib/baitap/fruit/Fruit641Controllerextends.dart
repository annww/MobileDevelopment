import 'package:get/get.dart';
import 'package:untitled/baitap/fruit/models64130758_datafruit.dart';

class Fruit641Controller extends GetxController{
  final _fruits = fruitsData;
  List<Fruit641> get fruits => _fruits;
  static Fruit641Controller get controller => Get.find<Fruit641Controller>();

  // void addToCart(Fruit641 fruit){
  //   for(var item in cart){
  //     if(item.id == fruit.id){
  //       item.sl++;
  //       return;
  //     }
  //   }
  //   cart.add(CartItem(id: fruit.id, sl: 1, gia: fruit.gia));
  // }
}

class Fruit641Bindings extends Bindings{

  @override
  void dependencies() {
    Get.put(Fruit641Controller());
  }
}