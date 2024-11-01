package thi.tai64132083.thigiuaki.modle;

public class SanPham {
    private int img;
    private String name;
    private String gia;

    public SanPham(int img, String name, String gia) {
        this.img = img;
        this.name = name;
        this.gia = gia;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
