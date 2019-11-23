package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.ChoThue;
import model.Product;

/**
 *
 * @author Administrator
 */
public class ChoThueDAO {

    //phuong thuc them vao mysql (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
    public static boolean insert_chothue(ChoThue c) throws SQLException {
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into chothue(chothue_loainhadat,chothue_gia,chothue_dientich,"
                    + "chothue_diadiem,chothue_matien,chothue_duongtruocnha,chothue_huongnha,chothue_sotang,chothue_sophong,"
                    + "chothue_sotoilet,chothue_tieude,chothue_mota,chothue_hinhanh,chothue_hoten,chothue_diachi,chothue_dienthoai,"
                    + "chothue_email,chothue_status,chothue_ngaydang) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, c.getChothue_loainhadat());
            ps.setDouble(2, c.getChothue_gia());
            ps.setDouble(3, c.getChothue_dientich());
            ps.setString(4, c.getChothue_diadiem());
            ps.setDouble(5, c.getChothue_matien());
            ps.setDouble(6, c.getChothue_duongtruocnha());
            ps.setString(7, c.getChothue_huongnha());
            ps.setDouble(8, c.getChothue_sotang());
            ps.setInt(9, c.getChothue_sophong());
            ps.setInt(10, c.getChothue_sotoilet());
            ps.setString(11, c.getChothue_tieude());
            ps.setString(12, c.getChothue_mota());
            ps.setString(13, c.getChothue_hinhanh());
            ps.setString(14, c.getChothue_hoten());
            ps.setString(15, c.getChothue_diachi());
            ps.setString(16, c.getChothue_dienthoai());
            ps.setString(17, c.getChothue_email());
            ps.setInt(18, c.getChothue_status());
            ps.setString(19, c.getChothue_ngaydang());
            int k = ps.executeUpdate();
            if (k > 0) {
                return true;
            }
        } catch (Exception ex) {

            if (ps != null) {
                ps.close();
            }

        } finally {
            conn.close();
            ps.close();
        }
        return false;

    }

    //phuong thuc arraylist lay' ds chothue boi chap nhan
    public static ArrayList<ChoThue> getListChoThueByChapNhan() throws SQLException {
        ArrayList<ChoThue> list = new ArrayList<ChoThue>();
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select*from chothue where chothue_status = 1 limit 20");
            rs = ps.executeQuery();
            while (rs.next()) {
                ChoThue c = new ChoThue();
                c.setChothue_id(rs.getInt("chothue_id"));
                c.setChothue_loainhadat(rs.getString("chothue_loainhadat"));
                c.setChothue_gia(rs.getDouble("chothue_gia"));
                c.setChothue_dientich(rs.getDouble("chothue_dientich"));
                c.setChothue_diadiem(rs.getString("chothue_diadiem"));
                c.setChothue_matien(rs.getDouble("chothue_matien"));
                c.setChothue_duongtruocnha(rs.getDouble("chothue_duongtruocnha"));
                c.setChothue_huongnha(rs.getString("chothue_huongnha"));
                c.setChothue_sotang(rs.getDouble("chothue_sotang"));
                c.setChothue_sophong(rs.getInt("chothue_sophong"));
                c.setChothue_sotoilet(rs.getInt("chothue_sotoilet"));
                c.setChothue_tieude(rs.getString("chothue_tieude"));
                c.setChothue_mota(rs.getString("chothue_mota"));
                c.setChothue_hinhanh(rs.getString("chothue_hinhanh"));
                c.setChothue_hoten(rs.getString("chothue_hoten"));
                c.setChothue_diachi(rs.getString("chothue_diachi"));
                c.setChothue_dienthoai(rs.getString("chothue_dienthoai"));
                c.setChothue_email(rs.getString("chothue_email"));
                c.setChothue_status(rs.getInt("chothue_status"));
                c.setChothue_ngaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("chothue_ngaydang")));
                list.add(c);
            }
        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            conn.close();

        }
        return list;

    }
    //phuong thuc arraylist lay' ds chothue
    public static ArrayList<ChoThue> GetALlList() throws SQLException {
        ArrayList<ChoThue> list = new ArrayList<ChoThue>();
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select*from chothue");
            rs = ps.executeQuery();
            while (rs.next()) {
                ChoThue c = new ChoThue();
                c.setChothue_id(rs.getInt("chothue_id"));
                c.setChothue_loainhadat(rs.getString("chothue_loainhadat"));
                c.setChothue_gia(rs.getDouble("chothue_gia"));
                c.setChothue_dientich(rs.getDouble("chothue_dientich"));
                c.setChothue_diadiem(rs.getString("chothue_diadiem"));
                c.setChothue_matien(rs.getDouble("chothue_matien"));
                c.setChothue_duongtruocnha(rs.getDouble("chothue_duongtruocnha"));
                c.setChothue_huongnha(rs.getString("chothue_huongnha"));
                c.setChothue_sotang(rs.getDouble("chothue_sotang"));
                c.setChothue_sophong(rs.getInt("chothue_sophong"));
                c.setChothue_sotoilet(rs.getInt("chothue_sotoilet"));
                c.setChothue_tieude(rs.getString("chothue_tieude"));
                c.setChothue_mota(rs.getString("chothue_mota"));
                c.setChothue_hinhanh(rs.getString("chothue_hinhanh"));
                c.setChothue_hoten(rs.getString("chothue_hoten"));
                c.setChothue_diachi(rs.getString("chothue_diachi"));
                c.setChothue_dienthoai(rs.getString("chothue_dienthoai"));
                c.setChothue_email(rs.getString("chothue_email"));
                c.setChothue_status(rs.getInt("chothue_status"));
                c.setChothue_ngaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("chothue_ngaydang")));
                list.add(c);
            }
        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            conn.close();

        }
        return list;

    }
    
    public static ArrayList<ChoThue> getListChoThueByChapNhan(int category_chothue_id) throws SQLException {
        ArrayList<ChoThue> list = new ArrayList<ChoThue>();
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select*from chothue where chothue_status = 1 and category_chothue_id ='" + category_chothue_id + "' ");
            rs = ps.executeQuery();
            while (rs.next()) {
                ChoThue c = new ChoThue();
                c.setChothue_id(rs.getInt("chothue_id"));
                c.setChothue_loainhadat(rs.getString("chothue_loainhadat"));
                c.setChothue_gia(rs.getDouble("chothue_gia"));
                c.setChothue_dientich(rs.getDouble("chothue_dientich"));
                c.setChothue_diadiem(rs.getString("chothue_diadiem"));
                c.setChothue_matien(rs.getDouble("chothue_matien"));
                c.setChothue_duongtruocnha(rs.getDouble("chothue_duongtruocnha"));
                c.setChothue_huongnha(rs.getString("chothue_huongnha"));
                c.setChothue_sotang(rs.getDouble("chothue_sotang"));
                c.setChothue_sophong(rs.getInt("chothue_sophong"));
                c.setChothue_sotoilet(rs.getInt("chothue_sotoilet"));
                c.setChothue_tieude(rs.getString("chothue_tieude"));
                c.setChothue_mota(rs.getString("chothue_mota"));
                c.setChothue_hinhanh(rs.getString("chothue_hinhanh"));
                c.setChothue_hoten(rs.getString("chothue_hoten"));
                c.setChothue_diachi(rs.getString("chothue_diachi"));
                c.setChothue_dienthoai(rs.getString("chothue_dienthoai"));
                c.setChothue_email(rs.getString("chothue_email"));
                c.setChothue_status(rs.getInt("chothue_status"));
                c.setChothue_ngaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("chothue_ngaydang")));
                list.add(c);
            }
        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            conn.close();

        }
        return list;

    }

    public static ArrayList<ChoThue> getProductSamePrice(Double d) throws SQLException {
        Connection con = DBConnect.getConnection();
        Double d1 = d - 0.6;
        Double d2 = d + 0.6;
        java.sql.PreparedStatement ps = con.prepareStatement("SELECT*FROM chothue WHERE chothue_gia >= '" + d1 + "' and chothue_gia <='" + d2 + "' and chothue_status = 1 limit 6");
        ResultSet rs = ps.executeQuery();

        ArrayList<ChoThue> list = new ArrayList<>();
        while (rs.next()) {
            ChoThue c = new ChoThue();
            c.setChothue_id(rs.getInt("chothue_id"));
            c.setChothue_loainhadat(rs.getString("chothue_loainhadat"));
            c.setChothue_gia(rs.getDouble("chothue_gia"));
            c.setChothue_dientich(rs.getDouble("chothue_dientich"));
            c.setChothue_diadiem(rs.getString("chothue_diadiem"));
            c.setChothue_matien(rs.getDouble("chothue_matien"));
            c.setChothue_duongtruocnha(rs.getDouble("chothue_duongtruocnha"));
            c.setChothue_huongnha(rs.getString("chothue_huongnha"));
            c.setChothue_sotang(rs.getDouble("chothue_sotang"));
            c.setChothue_sophong(rs.getInt("chothue_sophong"));
            c.setChothue_sotoilet(rs.getInt("chothue_sotoilet"));
            c.setChothue_tieude(rs.getString("chothue_tieude"));
            c.setChothue_mota(rs.getString("chothue_mota"));
            c.setChothue_hinhanh(rs.getString("chothue_hinhanh"));
            c.setChothue_hoten(rs.getString("chothue_hoten"));
            c.setChothue_diachi(rs.getString("chothue_diachi"));
            c.setChothue_dienthoai(rs.getString("chothue_dienthoai"));
            c.setChothue_email(rs.getString("chothue_email"));
            c.setChothue_status(rs.getInt("chothue_status"));
            c.setChothue_ngaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("chothue_ngaydang")));
            list.add(c);
        }
        return list;
    }

    public static ArrayList<ChoThue> getProductSameTieuDe(String tieude) throws SQLException {
        Connection con = DBConnect.getConnection();

        java.sql.PreparedStatement ps = con.prepareStatement("select*from chothue where chothue_loainhadat like '%" + tieude + "%' and chothue_status = 1 limit 6");
        ResultSet rs = ps.executeQuery();
        ArrayList<ChoThue> list = new ArrayList<>();
        while (rs.next()) {
            ChoThue c = new ChoThue();
            c.setChothue_id(rs.getInt("chothue_id"));
            c.setChothue_loainhadat(rs.getString("chothue_loainhadat"));
            c.setChothue_gia(rs.getDouble("chothue_gia"));
            c.setChothue_dientich(rs.getDouble("chothue_dientich"));
            c.setChothue_diadiem(rs.getString("chothue_diadiem"));
            c.setChothue_matien(rs.getDouble("chothue_matien"));
            c.setChothue_duongtruocnha(rs.getDouble("chothue_duongtruocnha"));
            c.setChothue_huongnha(rs.getString("chothue_huongnha"));
            c.setChothue_sotang(rs.getDouble("chothue_sotang"));
            c.setChothue_sophong(rs.getInt("chothue_sophong"));
            c.setChothue_sotoilet(rs.getInt("chothue_sotoilet"));
            c.setChothue_tieude(rs.getString("chothue_tieude"));
            c.setChothue_mota(rs.getString("chothue_mota"));
            c.setChothue_hinhanh(rs.getString("chothue_hinhanh"));
            c.setChothue_hoten(rs.getString("chothue_hoten"));
            c.setChothue_diachi(rs.getString("chothue_diachi"));
            c.setChothue_dienthoai(rs.getString("chothue_dienthoai"));
            c.setChothue_email(rs.getString("chothue_email"));
            c.setChothue_status(rs.getInt("chothue_status"));
            c.setChothue_ngaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("chothue_ngaydang")));
            list.add(c);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        for (ChoThue c : ChoThueDAO.getProductSameTieuDe("Cho")) {
            System.out.println(c.getChothue_tieude() );
        }
    }

    //phuong thuc tim san pham cho thue boi ID
    public static ChoThue getChoThueByID(int id) throws SQLException {
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ChoThue c = new ChoThue();
        try {
            ps = conn.prepareStatement("select*from chothue where chothue_id='" + id + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setChothue_id(rs.getInt("chothue_id"));
                c.setChothue_loainhadat(rs.getString("chothue_loainhadat"));
                c.setChothue_gia(rs.getDouble("chothue_gia"));
                c.setChothue_dientich(rs.getDouble("chothue_dientich"));
                c.setChothue_diadiem(rs.getString("chothue_diadiem"));
                c.setChothue_matien(rs.getDouble("chothue_matien"));
                c.setChothue_duongtruocnha(rs.getDouble("chothue_duongtruocnha"));
                c.setChothue_huongnha(rs.getString("chothue_huongnha"));
                c.setChothue_sotang(rs.getDouble("chothue_sotang"));
                c.setChothue_sophong(rs.getInt("chothue_sophong"));
                c.setChothue_sotoilet(rs.getInt("chothue_sotoilet"));
                c.setChothue_tieude(rs.getString("chothue_tieude"));
                c.setChothue_mota(rs.getString("chothue_mota"));
                c.setChothue_hinhanh(rs.getString("chothue_hinhanh"));
                c.setChothue_hoten(rs.getString("chothue_hoten"));
                c.setChothue_diachi(rs.getString("chothue_diachi"));
                c.setChothue_dienthoai(rs.getString("chothue_dienthoai"));
                c.setChothue_email(rs.getString("chothue_email"));
                c.setChothue_status(rs.getInt("chothue_status"));
                c.setChothue_ngaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("chothue_ngaydang")));
            }

        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            conn.close();
        }
        return c;
    }

}
