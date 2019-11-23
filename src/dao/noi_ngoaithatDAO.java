package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.noi_ngoaithat;

public class noi_ngoaithatDAO {

    //phuong thuc hien tat ca ra 
    public static ArrayList<noi_ngoaithat> getListnoingoai() throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select*from noi_ngoai_that");
        ResultSet rs = ps.executeQuery();
        ArrayList<noi_ngoaithat> list = new ArrayList<>();
        while (rs.next()) {
            noi_ngoaithat n = new noi_ngoaithat();
            n.setId_NoiNgoaiThat(rs.getInt("ID_noingoaithat"));
            n.setNoiNgoaiThat_Image(rs.getString("image_noingoaithat"));
            n.setNoiNgoaiThat_TieuDe(rs.getString("tieude_noingoaithat"));
            n.setNoiNgoaiThat_NoiDung(rs.getString("noidung_noingoaithat"));
            list.add(n);
        }
        return list;
    }

    //phuong thuc hien chi tiet theo id parameter
    public static noi_ngoaithat getChitiet(int id) throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select*from noi_ngoai_that where ID_noingoaithat='" + id + "' ");
        ResultSet rs = ps.executeQuery();
        noi_ngoaithat n = new noi_ngoaithat();
        while (rs.next()) {
            n.setId_NoiNgoaiThat(rs.getInt("ID_noingoaithat"));
            n.setNoiNgoaiThat_Image(rs.getString("image_noingoaithat"));
            n.setNoiNgoaiThat_TieuDe(rs.getString("tieude_noingoaithat"));
            n.setNoiNgoaiThat_NoiDung(rs.getString("noidung_noingoaithat"));
        }
        return n;
    }
    //test
    public static void main(String[] args) throws SQLException 
    {
        System.out.println(noi_ngoaithatDAO.getChitiet(1).getNoiNgoaiThat_TieuDe() );
    }
}
