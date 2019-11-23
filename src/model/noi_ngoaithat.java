  
package model;


public class noi_ngoaithat
{
    private int id_NoiNgoaiThat;
    private String NoiNgoaiThat_Image;
    private String  NoiNgoaiThat_TieuDe;
    private String NoiNgoaiThat_NoiDung;

    public noi_ngoaithat() {
    }

    public noi_ngoaithat(int id_NoiNgoaiThat, String NoiNgoaiThat_Image, String NoiNgoaiThat_TieuDe, String NoiNgoaiThat_NoiDung) {
        this.id_NoiNgoaiThat = id_NoiNgoaiThat;
        this.NoiNgoaiThat_Image = NoiNgoaiThat_Image;
        this.NoiNgoaiThat_TieuDe = NoiNgoaiThat_TieuDe;
        this.NoiNgoaiThat_NoiDung = NoiNgoaiThat_NoiDung;
    }

    public int getId_NoiNgoaiThat() {
        return id_NoiNgoaiThat;
    }

    public void setId_NoiNgoaiThat(int id_NoiNgoaiThat) {
        this.id_NoiNgoaiThat = id_NoiNgoaiThat;
    }

    public String getNoiNgoaiThat_Image() {
        return NoiNgoaiThat_Image;
    }

    public void setNoiNgoaiThat_Image(String NoiNgoaiThat_Image) {
        this.NoiNgoaiThat_Image = NoiNgoaiThat_Image;
    }

    public String getNoiNgoaiThat_TieuDe() {
        return NoiNgoaiThat_TieuDe;
    }

    public void setNoiNgoaiThat_TieuDe(String NoiNgoaiThat_TieuDe) {
        this.NoiNgoaiThat_TieuDe = NoiNgoaiThat_TieuDe;
    }

    public String getNoiNgoaiThat_NoiDung() {
        return NoiNgoaiThat_NoiDung;
    }

    public void setNoiNgoaiThat_NoiDung(String NoiNgoaiThat_NoiDung) {
        this.NoiNgoaiThat_NoiDung = NoiNgoaiThat_NoiDung;
    }
    
     
}
