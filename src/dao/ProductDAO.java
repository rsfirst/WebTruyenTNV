
package dao;

import com.mysql.jdbc.PreparedStatement;
import connect.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.PostMua;
import model.Product;

public class ProductDAO 
{   
    public static int fkosdf() throws SQLException
    {
        Boolean con = DBConnect.getConnection().prepareStatement("").executeQuery().next();
        
        return 0;
    }
    
    public static int countbaidangmua() throws SQLException
    {
      Connection con = DBConnect.getConnection();
      java.sql.PreparedStatement ps = con.prepareStatement("select*from dangtinmua ");
      int count = 0;
      ResultSet rs = ps.executeQuery();
      PostMua p = new PostMua();
      while(rs.next() )
      {
          p.setStt(rs.getInt("stt"));
          count++;
      }
      return count;
    }
    public static int countbaidangban() throws SQLException
    {
      Connection con = DBConnect.getConnection();
      java.sql.PreparedStatement ps = con.prepareStatement("select*from product ");
      int count = 0;
      ResultSet rs = ps.executeQuery();
      PostMua p = new PostMua();
      while(rs.next() )
      {
          p.setStt(rs.getInt("product_id"));
          count++;
      }
      return count;
    }
    
    public static ArrayList<Product> getListProductByNav(long category_id,int firstResult,int maxResult) throws SQLException
    {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select*from product where category_id='"+category_id+"' limit ? ,? ");
        ps.setInt(1, firstResult);
        ps.setInt(2, maxResult);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {
            Product p = new Product();
            p.setProductID(rs.getLong("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductImage(rs.getString("product_image"));
            p.setProductPrice(rs.getDouble("product_price"));
            p.setProductDescription(rs.getString("product_description"));
            p.setSdt(rs.getString("product_sdt"));
            p.setDientich(rs.getDouble("product_dientich"));
            p.setHoten(rs.getString("product_hoten"));
            p.setVitri(rs.getString("product_vitri"));
            p.setNgaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("product_ngaydang")) );
            p.setHinhthuc(rs.getString("product_hinhthuc"));
            
            list.add(p);
        }
        return list;
    }
    //tinh tong san pham cua danh muc
    public static int countProductByCategory(long CategoryID) throws SQLException
    {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select*from product where category_id='"+CategoryID+"' ");
        ResultSet rs = ps.executeQuery();
        int count = 0 ;
        while(rs.next())
        {
            int k = rs.getInt("product_id");
            count++;
        }
        return count;
    }
    //tim kiem theo ten bai product
    public static ArrayList<Product> getTimKiem(String ten) throws SQLException
    {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select*from product where product_name like '%"+ten+"%' ");
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {
            Product p = new Product();
            p.setProductID(rs.getInt("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductImage(rs.getString("product_image"));
            p.setProductPrice(rs.getDouble("product_price"));
            p.setProductDescription(rs.getString("product_description"));
            list.add(p);
        }
        return list;
    }
    //Đưa Tât Cả Sản Phẩm Từ Category_id ra Khi bấm vào danh mục đó
    public static ArrayList<Product> getListProductByCategory(long category_id) throws SQLException
    {
        Connection connection = DBConnect.getConnection();
        String sql ="select*from product where category_id='"+category_id+"' ";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {
            Product product = new Product();
            product.setProductID(rs.getInt("category_id"));
            product.setCategoryID(rs.getInt("category_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDescription(rs.getString("product_description"));
            product.setNgaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("product_ngaydang")) );
            list.add(product);
        }
        return list;
    }
    
     // hiển thị chi tiết sản phẩm
    public static Product getProduct(long productID) throws SQLException
    {
        Connection con = DBConnect.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement("SELECT*FROM product WHERE product_id='"+productID+"' ");
        ResultSet rs = ps.executeQuery();
        Product p = new Product();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {   
            p.setProductID(rs.getLong("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductImage(rs.getString("product_image"));
            p.setProductPrice(rs.getDouble("product_price"));
            p.setProductDescription(rs.getString("product_description"));
            p.setSdt(rs.getString("product_sdt"));
            p.setHinhthuc(rs.getString("product_hinhthuc") );
            p.setDientich(rs.getDouble("product_dientich"));
            p.setHoten(rs.getString("product_hoten"));
            p.setVitri(rs.getString("product_vitri"));
            p.setNgaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("product_ngaydang")) );
            list.add(p);
        }
        return p;
    }
    public static ArrayList<Product> getProductSamePrice(Double d) throws SQLException
    {
        Connection con = DBConnect.getConnection();
        Double d1 = d - 0.6;Double d2 = d + 0.6;
        java.sql.PreparedStatement ps = con.prepareStatement("SELECT*FROM product WHERE product_price >= '"+d1+"' and product_price<='"+d2+"' limit 6");
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {   
            Product p = new Product();
            p.setProductID(rs.getLong("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductImage(rs.getString("product_image"));
            p.setProductPrice(rs.getDouble("product_price"));
            p.setProductDescription(rs.getString("product_description"));
            p.setSdt(rs.getString("product_sdt"));
            p.setHinhthuc(rs.getString("product_hinhthuc") );
            p.setDientich(rs.getDouble("product_dientich"));
            p.setHoten(rs.getString("product_hoten"));
            p.setVitri(rs.getString("product_vitri"));
            p.setNgaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("product_ngaydang")) );
            list.add(p);
        }
        return list;
    }
    
    public static ArrayList<Product> getProductSameTieuDe(String tieude) throws SQLException
    {
        Connection con = DBConnect.getConnection();
        
        java.sql.PreparedStatement ps = con.prepareStatement("select*from product where product_name like '%"+tieude+"%' limit 6");
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {   
            Product p = new Product();
            p.setProductID(rs.getLong("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductImage(rs.getString("product_image"));
            p.setProductPrice(rs.getDouble("product_price"));
            p.setProductDescription(rs.getString("product_description"));
            p.setSdt(rs.getString("product_sdt"));
            p.setHinhthuc(rs.getString("product_hinhthuc") );
            p.setDientich(rs.getDouble("product_dientich"));
            p.setHoten(rs.getString("product_hoten"));
            p.setVitri(rs.getString("product_vitri"));
            p.setNgaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("product_ngaydang")) );
            list.add(p);
        }
        return list;
    }
    
    public static void main(String[] args) throws SQLException
    {
        for(Product p :ProductDAO.getProductSamePrice(2.2) )
        {
            System.out.println(p.getProductID() );
        }
                
    }
    //hien thi tat ca san pham
    public static ArrayList<Product> getListProduct() throws SQLException
    {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select*from product limit 20");
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next())
        {
            Product p = new Product();
            p.setProductID(rs.getLong("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductImage(rs.getString("product_image"));
            p.setProductPrice(rs.getDouble("product_price"));
            p.setProductDescription(rs.getString("product_description"));
            p.setSdt(rs.getString("product_sdt"));
            p.setDientich(rs.getDouble("product_dientich"));
            p.setHoten(rs.getString("product_hoten"));
            p.setVitri(rs.getString("product_vitri"));
            p.setNgaydang(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("product_ngaydang")) );
            p.setHinhthuc(rs.getString("product_hinhthuc"));
            list.add(p);
        }
        Collections.sort(list,new Comparator<Product>()
        {
            @Override
            public int compare(Product t, Product t1) 
            {
                return t1.getNgaydang().compareTo(t.getNgaydang());
            }
            
        });
        return list;
    }
    
    
    
    
}
