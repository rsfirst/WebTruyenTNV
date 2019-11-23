/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */


public class ChoThue 
{
    private int chothue_id;
    //thong tin co ban
    private String chothue_loainhadat;
    private double chothue_gia;
    private double chothue_dientich;
    private String chothue_diadiem;
    //thong tin khac
    private double chothue_matien;
    private double chothue_duongtruocnha;
    private String chothue_huongnha;
    private double chothue_sotang;
    private int chothue_sophong;
    private int chothue_sotoilet;
    //mo ta chi tiet
    private String chothue_tieude;
    private String chothue_mota;
    private String chothue_hinhanh;
    //thong tin lien he
    private String chothue_hoten;
    private String chothue_diachi;
    private String chothue_dienthoai;
    private String chothue_email;
    //status
    private int chothue_status;
    private String chothue_ngaydang;
    
    public ChoThue() {
    }

    public ChoThue(String chothue_loainhadat, double chothue_gia, double chothue_dientich, String chothue_diadiem, double chothue_matien, double chothue_duongtruocnha, String chothue_huongnha, double chothue_sotang, int chothue_sophong, int chothue_sotoilet, String chothue_tieude, String chothue_mota, String chothue_hinhanh, String chothue_hoten, String chothue_diachi, String chothue_dienthoai, String chothue_email, int chothue_status, String chothue_ngaydang) {
        this.chothue_loainhadat = chothue_loainhadat;
        this.chothue_gia = chothue_gia;
        this.chothue_dientich = chothue_dientich;
        this.chothue_diadiem = chothue_diadiem;
        this.chothue_matien = chothue_matien;
        this.chothue_duongtruocnha = chothue_duongtruocnha;
        this.chothue_huongnha = chothue_huongnha;
        this.chothue_sotang = chothue_sotang;
        this.chothue_sophong = chothue_sophong;
        this.chothue_sotoilet = chothue_sotoilet;
        this.chothue_tieude = chothue_tieude;
        this.chothue_mota = chothue_mota;
        this.chothue_hinhanh = chothue_hinhanh;
        this.chothue_hoten = chothue_hoten;
        this.chothue_diachi = chothue_diachi;
        this.chothue_dienthoai = chothue_dienthoai;
        this.chothue_email = chothue_email;
        this.chothue_status = chothue_status;
        this.chothue_ngaydang = chothue_ngaydang;
    }
    
    
    
    public ChoThue(int chothue_id, String chothue_loainhadat, double chothue_gia, double chothue_dientich, String chothue_diadiem, double chothue_matien, double chothue_duongtruocnha, String chothue_huongnha, double chothue_sotang, int chothue_sophong, int chothue_sotoilet, String chothue_tieude, String chothue_mota, String chothue_hinhanh, String chothue_hoten, String chothue_diachi, String chothue_dienthoai, String chothue_email, int chothue_status,String chothue_ngaydang) {
        this.chothue_id = chothue_id;
        this.chothue_loainhadat = chothue_loainhadat;
        this.chothue_gia = chothue_gia;
        this.chothue_dientich = chothue_dientich;
        this.chothue_diadiem = chothue_diadiem;
        this.chothue_matien = chothue_matien;
        this.chothue_duongtruocnha = chothue_duongtruocnha;
        this.chothue_huongnha = chothue_huongnha;
        this.chothue_sotang = chothue_sotang;
        this.chothue_sophong = chothue_sophong;
        this.chothue_sotoilet = chothue_sotoilet;
        this.chothue_tieude = chothue_tieude;
        this.chothue_mota = chothue_mota;
        this.chothue_hinhanh = chothue_hinhanh;
        this.chothue_hoten = chothue_hoten;
        this.chothue_diachi = chothue_diachi;
        this.chothue_dienthoai = chothue_dienthoai;
        this.chothue_email = chothue_email;
        this.chothue_status = chothue_status;
        this.chothue_ngaydang = chothue_ngaydang;
    }

    public int getChothue_id() {
        return chothue_id;
    }

    public void setChothue_id(int chothue_id) {
        this.chothue_id = chothue_id;
    }

    public String getChothue_loainhadat() {
        return chothue_loainhadat;
    }

    public void setChothue_loainhadat(String chothue_loainhadat) {
        this.chothue_loainhadat = chothue_loainhadat;
    }

    public double getChothue_gia() {
        return chothue_gia;
    }

    public void setChothue_gia(double chothue_gia) {
        this.chothue_gia = chothue_gia;
    }

    public double getChothue_dientich() {
        return chothue_dientich;
    }

    public void setChothue_dientich(double chothue_dientich) {
        this.chothue_dientich = chothue_dientich;
    }

    public String getChothue_diadiem() {
        return chothue_diadiem;
    }

    public void setChothue_diadiem(String chothue_diadiem) {
        this.chothue_diadiem = chothue_diadiem;
    }

    public double getChothue_matien() {
        return chothue_matien;
    }

    public void setChothue_matien(double chothue_matien) {
        this.chothue_matien = chothue_matien;
    }

    public double getChothue_duongtruocnha() {
        return chothue_duongtruocnha;
    }

    public void setChothue_duongtruocnha(double chothue_duongtruocnha) {
        this.chothue_duongtruocnha = chothue_duongtruocnha;
    }

    public String getChothue_huongnha() {
        return chothue_huongnha;
    }

    public void setChothue_huongnha(String chothue_huongnha) {
        this.chothue_huongnha = chothue_huongnha;
    }

    public double getChothue_sotang() {
        return chothue_sotang;
    }

    public void setChothue_sotang(double chothue_sotang) {
        this.chothue_sotang = chothue_sotang;
    }

    public int getChothue_sophong() {
        return chothue_sophong;
    }

    public void setChothue_sophong(int chothue_sophong) {
        this.chothue_sophong = chothue_sophong;
    }

    public int getChothue_sotoilet() {
        return chothue_sotoilet;
    }

    public void setChothue_sotoilet(int chothue_sotoilet) {
        this.chothue_sotoilet = chothue_sotoilet;
    }

    public String getChothue_tieude() {
        return chothue_tieude;
    }

    public void setChothue_tieude(String chothue_tieude) {
        this.chothue_tieude = chothue_tieude;
    }

    public String getChothue_mota() {
        return chothue_mota;
    }

    public void setChothue_mota(String chothue_mota) {
        this.chothue_mota = chothue_mota;
    }

    public String getChothue_hinhanh() {
        return chothue_hinhanh;
    }

    public void setChothue_hinhanh(String chothue_hinhanh) {
        this.chothue_hinhanh = chothue_hinhanh;
    }

    public String getChothue_hoten() {
        return chothue_hoten;
    }

    public void setChothue_hoten(String chothue_hoten) {
        this.chothue_hoten = chothue_hoten;
    }

    public String getChothue_diachi() {
        return chothue_diachi;
    }

    public void setChothue_diachi(String chothue_diachi) {
        this.chothue_diachi = chothue_diachi;
    }

    public String getChothue_dienthoai() {
        return chothue_dienthoai;
    }

    public void setChothue_dienthoai(String chothue_dienthoai) {
        this.chothue_dienthoai = chothue_dienthoai;
    }

    public String getChothue_email() {
        return chothue_email;
    }

    public void setChothue_email(String chothue_email) {
        this.chothue_email = chothue_email;
    }

    public int getChothue_status() {
        return chothue_status;
    }

    public void setChothue_status(int chothue_status) {
        this.chothue_status = chothue_status;
    }

    public String getChothue_ngaydang() {
        return chothue_ngaydang;
    }

    public void setChothue_ngaydang(String chothue_ngaydang) {
        this.chothue_ngaydang = chothue_ngaydang;
    }

}
