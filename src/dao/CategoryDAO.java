
package dao;

import com.mysql.jdbc.PreparedStatement;
import connect.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

public class CategoryDAO 
{
    public ArrayList<Category> getListCategory() throws SQLException
    {
        Connection connection = DBConnect.getConnection();
        String sql = "select*from category";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Category> list = new ArrayList<>();
        while(rs.next())
        {
            list.add(new Category(rs.getLong("category_id"),rs.getString("category_name")));
        }
        return list;
    }
    public ArrayList<Category> getListCategoryChoThue() throws SQLException
    {
        Connection connection = DBConnect.getConnection();
        String sql = "select*from category_chothue";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Category> list = new ArrayList<>();
        while(rs.next())
        {
            list.add(new Category(rs.getInt("category_chothue_id"),rs.getString("category_chothue_name")));
        }
        return list;
    }
    public static void main(String[] args) throws SQLException 
    {
        
        
    }
    //them moi du lieu
    public boolean insertCategory(Category c)
    {
        Connection con = DBConnect.getConnection();
        try 
        {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into category values(?,?)");
            ps.setInt(1, (int) c.getCategoryID());
            ps.setString(2,c.getCategoryName());
            return ps.executeUpdate() ==1;
        } catch (SQLException ex) 
        {
            System.out.println("Loi" +ex.getMessage());
        }
        return false;
    }
    //cap nhat
    public boolean updateCategory(Category c)
    {
        Connection con = DBConnect.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("update category set category_name=? where category_id=? ");
            ps.setInt(1, (int) c.getCategoryID());
            ps.setString(2,c.getCategoryName());
            return ps.executeUpdate() ==1;
        } catch (SQLException ex)
        {
            System.out.println("Loi "+ ex.getMessage());
        }
        return false;
    }
    //cap nhat 2 
    public static void capnhat(String name,String id)
    {
        Connection con = DBConnect.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("update category set category_name='"+name+"' where category_id='"+id+"' ");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi " +ex.getMessage());
        }
    }
    
    //xoa 
    public boolean deleteCategory(long category_id)
    {
        Connection con = DBConnect.getConnection();
        try 
        {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from category where category_id=?  ");
            ps.setLong(1, category_id);
            return ps.executeUpdate()==1;
        } catch (SQLException ex)
        {
            System.out.println("Loi "+ ex.getMessage());
        }
        return false;
    }
}
