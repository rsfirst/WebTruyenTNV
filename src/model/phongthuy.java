
package model;


public class phongthuy 
{
    private int iD_PhongThuy;
    private String phongThuy_Image;
    private String  phongThuy_TieuDe;
    private String phongThuy_NoiDung;

    public phongthuy() {
    }

    public phongthuy(int iD_PhongThuy, String phongThuy_Image, String phongThuy_TieuDe, String phongThuy_NoiDung) {
        this.iD_PhongThuy = iD_PhongThuy;
        this.phongThuy_Image = phongThuy_Image;
        this.phongThuy_TieuDe = phongThuy_TieuDe;
        this.phongThuy_NoiDung = phongThuy_NoiDung;
    }

    public int getiD_PhongThuy() {
        return iD_PhongThuy;
    }

    public void setiD_PhongThuy(int iD_PhongThuy) {
        this.iD_PhongThuy = iD_PhongThuy;
    }

    public String getPhongThuy_Image() {
        return phongThuy_Image;
    }

    public void setPhongThuy_Image(String phongThuy_Image) {
        this.phongThuy_Image = phongThuy_Image;
    }

    public String getPhongThuy_TieuDe() {
        return phongThuy_TieuDe;
    }

    public void setPhongThuy_TieuDe(String phongThuy_TieuDe) {
        this.phongThuy_TieuDe = phongThuy_TieuDe;
    }

    public String getPhongThuy_NoiDung() {
        return phongThuy_NoiDung;
    }

    public void setPhongThuy_NoiDung(String phongThuy_NoiDung) {
        this.phongThuy_NoiDung = phongThuy_NoiDung;
    }
           
}
