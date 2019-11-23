package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.phongthuy;

public class PhongThuyDAO {

    //phuong thuc tao hien thi thong tin ra web
    public static ArrayList<phongthuy> getListPhongThuy() throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select*from trangphongthuy");
        ResultSet rs = ps.executeQuery();
        ArrayList<phongthuy> list = new ArrayList<>();
        while (rs.next()) {
            phongthuy p = new phongthuy();
            p.setiD_PhongThuy(rs.getInt("phongthuy_ID"));
            p.setPhongThuy_TieuDe(rs.getString("phongthuy_tieude"));
            p.setPhongThuy_Image(rs.getString("phongthuy_Image"));
            p.setPhongThuy_NoiDung(rs.getString("phongthuy_noidung"));
            list.add(p);
        }
        return list;
    }

    //phuong thuc get chi tiet bai viet phong thuy
    public static phongthuy getChiTiet(int id) throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select*from trangphongthuy where phongthuy_ID='" + id + "' ");
        ResultSet rs = ps.executeQuery();
        phongthuy p = new phongthuy();
        while (rs.next()) 
        {
            p.setiD_PhongThuy(rs.getInt("phongthuy_ID"));
            p.setPhongThuy_TieuDe(rs.getString("phongthuy_tieude"));
            p.setPhongThuy_Image(rs.getString("phongthuy_Image"));
            p.setPhongThuy_NoiDung(rs.getString("phongthuy_noidung"));
        }
        return p;
    }

    public static void main(String[] args) throws SQLException
    {   
        //test
        System.out.println(PhongThuyDAO.getChiTiet(1).getPhongThuy_TieuDe() );
    }
}
