/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ChoThue;

/**
 *
 * @author Administrator
 */
public class DuyetBaiDAO {

    //phuong thuc set chothue_status = 1 = duyet bai
    public static boolean ChapNhanBaiDang(int id) throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("update chothue set chothue_status =1 where chothue_id='" + id + "'");
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            con.close();
        }
        return false;
    }

    public static ChoThue getChoThue(int id) throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ChoThue c = new ChoThue();
        try 
        {
            ps = con.prepareStatement("select chothue_hoten from chothue where chothue_id='"+id+"' ");
            rs = ps.executeQuery();
            while(rs.next())
            {
                c.setChothue_hoten(rs.getString("chothue_hoten"));
            }
        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            con.close();
        }
        return c;

    }
    public static void main(String[] args) throws SQLException {
        System.out.println(DuyetBaiDAO.getChoThue(4).getChothue_hoten());
    }
    //phuong thuc xoa bai viet
    public static boolean xoaBaiDang(int id) throws SQLException {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from chothue where chothue_id='" + id + "'");
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            if (ps != null) {
                ps.close();
            }
        } finally {
            ps.close();
            con.close();
        }
        return false;
    }

}
