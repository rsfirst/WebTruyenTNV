package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.xaydung_kientruc;

public class xaydung_kientrucDAO {

    //phuong thuc hien ra tat ca danh sach
    public static ArrayList<xaydung_kientruc> getListxaydung_kientruc() throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select*from xaydung_kientruc");
        ResultSet rs = ps.executeQuery();
        ArrayList<xaydung_kientruc> list = new ArrayList<>();
        while (rs.next()) {
            xaydung_kientruc x = new xaydung_kientruc();
            x.setiD_xaydung_kientruc(rs.getInt("xaydung_kientruc_ID"));
            x.setXaydung_kientruc_TieuDe(rs.getString("xaydung_kientruc_tieude"));
            x.setXaydung_kientruc_Image(rs.getString("xaydung_kientruc_Image"));
            x.setXaydung_kientruc_NoiDung(rs.getString("xaydung_kientruc_noidung"));
            list.add(x);
        }
        return list;
    }

    //phuong thuc hien chi tiet theo ID 
    public static xaydung_kientruc getChitiet(int id) throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select*from xaydung_kientruc where xaydung_kientruc_ID='" + id + "'");
        ResultSet rs = ps.executeQuery();
        xaydung_kientruc x = new xaydung_kientruc();
        while (rs.next()) {
            x.setiD_xaydung_kientruc(rs.getInt("xaydung_kientruc_ID"));
            x.setXaydung_kientruc_TieuDe(rs.getString("xaydung_kientruc_tieude"));
            x.setXaydung_kientruc_Image(rs.getString("xaydung_kientruc_Image"));
            x.setXaydung_kientruc_NoiDung(rs.getString("xaydung_kientruc_noidung"));
        }
        return x;
    }
    //test
    public static void main(String[] args) throws SQLException 
    {   
        System.out.println("get ArrayList");
        for(xaydung_kientruc x:xaydung_kientrucDAO.getListxaydung_kientruc() )
        {
            System.out.println(x.getXaydung_kientruc_TieuDe());
        }
        System.out.println("get Chi tiet");
        System.out.println(xaydung_kientrucDAO.getChitiet(1).getXaydung_kientruc_TieuDe()  );
    }
}
