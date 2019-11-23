
package model;


public class xaydung_kientruc
{
    private int iD_xaydung_kientruc;
    private String xaydung_kientruc_Image;
    private String  xaydung_kientruc_TieuDe;
    private String xaydung_kientruc_NoiDung;

    public xaydung_kientruc() {
    }

    public xaydung_kientruc(int iD_xaydung_kientruc, String xaydung_kientruc_Image, String xaydung_kientruc_TieuDe, String xaydung_kientruc_NoiDung) {
        this.iD_xaydung_kientruc = iD_xaydung_kientruc;
        this.xaydung_kientruc_Image = xaydung_kientruc_Image;
        this.xaydung_kientruc_TieuDe = xaydung_kientruc_TieuDe;
        this.xaydung_kientruc_NoiDung = xaydung_kientruc_NoiDung;
    }

    public int getiD_xaydung_kientruc() {
        return iD_xaydung_kientruc;
    }

    public void setiD_xaydung_kientruc(int iD_xaydung_kientruc) {
        this.iD_xaydung_kientruc = iD_xaydung_kientruc;
    }

    public String getXaydung_kientruc_Image() {
        return xaydung_kientruc_Image;
    }

    public void setXaydung_kientruc_Image(String xaydung_kientruc_Image) {
        this.xaydung_kientruc_Image = xaydung_kientruc_Image;
    }

    public String getXaydung_kientruc_TieuDe() {
        return xaydung_kientruc_TieuDe;
    }

    public void setXaydung_kientruc_TieuDe(String xaydung_kientruc_TieuDe) {
        this.xaydung_kientruc_TieuDe = xaydung_kientruc_TieuDe;
    }

    public String getXaydung_kientruc_NoiDung() {
        return xaydung_kientruc_NoiDung;
    }

    public void setXaydung_kientruc_NoiDung(String xaydung_kientruc_NoiDung) {
        this.xaydung_kientruc_NoiDung = xaydung_kientruc_NoiDung;
    }
    
    
}
