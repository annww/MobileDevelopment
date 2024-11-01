class Fruit641{
  String id, ten;
  int gia;
  String? anh;
  String? mota;

  Fruit641({
    required this.id,
    required this.ten,
    required this.gia,
    this.anh,
    this.mota,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': this.id,
      'ten': this.ten,
      'gia': this.gia,
      'anh': this.anh,
      'mota': this.mota,
    };
  }

  factory Fruit641.fromMap(Map<String, dynamic> map) {
    return Fruit641(
      id: map['id'] as String,
      ten: map['ten'] as String,
      gia: map['gia'] as int,
      anh: map['anh'] as String,
      mota: map['mota'] as String,
    );
  }
}

class CartItem{
  String id;
  int sl, gia;

  CartItem({
    required this.id,
    required this.sl,
    required this.gia,
  });
}

Map<String, String> images = {
  "bưởi": "https://thucphamdongxanh.com/wp-content/uploads/2019/07/buoi-da-xanh-ngot.jpg",
  "xoài": "https://vnn-imgs-f.vgcloud.vn/2019/06/01/14/tu-vu-be-9-tuoi-suyt-chet-vi-an-xoai-chuyen-gia-canh-bao-khong-an-xoai-neu-co-dau-hieu-sau.jpg",
  "mít": "https://giayphepluuhanhtudo.com/ckfinder/userfiles/images/Frozen-JackFruit-high-quality-from-Vietnam.jpg",
  "cam": "https://dichothue.com.vn/thumbs/1100x1100x2/upload/product/cam-my-7852.jpg",
  "dâu": "https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-asm/posts/dau-tay-10.webp",
};

final fruitsData = [
  Fruit641(id: "01", ten: "Bưởi", gia: 12000, anh: images["bưởi"], mota: "Bưởi ngon"),
  Fruit641(id: "02", ten: "Xoài", gia: 32000, anh: images["xoài"], mota: "Xoài thái"),
  Fruit641(id: "03", ten: "Mít", gia: 50000, anh: images["mít"], mota: "Mít Indo"),
  Fruit641(id: "04", ten: "Cam", gia: 30000, anh: images["cam"], mota: "Cam Vn"),
  Fruit641(id: "05", ten: "Dâu", gia: 60000, anh: images["dâu"], mota: "Dâu Đà lạt"),
  Fruit641(id: "06", ten: "Sơ ri", gia: 60000, anh: images["dâu"], mota: "Dâu Đà lạt"),
  Fruit641(id: "07", ten: "Ổi", gia: 60000, anh: images["dâu"], mota: "Dâu Đà lạt"),
  Fruit641(id: "08", ten: "Quýt", gia: 60000, anh: images["dâu"], mota: "Dâu Đà lạt"),
  Fruit641(id: "09", ten: "Chôm Chôm", gia: 60000, anh: images["dâu"], mota: "Dâu Đà lạt"),
  Fruit641(id: "10", ten: "Táo", gia: 60000, anh: images["dâu"], mota: "Dâu Đà lạt"),
];