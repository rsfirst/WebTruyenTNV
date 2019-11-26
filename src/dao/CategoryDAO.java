
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import model.Category;

public class CategoryDAO {
	public ArrayList<Category> getListCategory(String menuId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Category> list = new ArrayList<>();
		try {
			conn = DBConnect.getConnection();
			String sql = "select * from category where status='1' and menu_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, menuId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Category category = new Category();
				category.setCategoryID(rs.getLong(i++));
				category.setCategoryName(rs.getString(i++));
				category.setMenuId(rs.getInt(i++));
				category.setLinkMenu(rs.getString(i++));
				category.setStatus(rs.getString(i++));
				category.setOrderNumber(rs.getString(i++));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return list;
	}
	public ArrayList<Category> getListCategory() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Category> list = new ArrayList<>();
		try {
			conn = DBConnect.getConnection();
			String sql = "select * from category where status='1' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Category category = new Category();
				category.setCategoryID(rs.getLong(i++));
				category.setCategoryName(rs.getString(i++));
				category.setMenuId(rs.getInt(i++));
				category.setLinkMenu(rs.getString(i++));
				category.setStatus(rs.getString(i++));
				category.setOrderNumber(rs.getString(i++));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return list;
	}
	public ArrayList<Category> getListCategoryChoThue() throws SQLException {
		Connection connection = DBConnect.getConnection();
		String sql = "select*from category_chothue";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Category> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new Category(rs.getInt("category_chothue_id"), rs.getString("category_chothue_name")));
		}
		return list;
	}

	public static void main(String[] args) throws SQLException {

	}

	// them moi du lieu
	public boolean insertCategory(Category c) {
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into category values(?,?)");
			ps.setInt(1, (int) c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Loi" + ex.getMessage());
		}
		return false;
	}

	// cap nhat
	public boolean updateCategory(Category c) {
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("update category set category_name=? where category_id=? ");
			ps.setInt(1, (int) c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Loi " + ex.getMessage());
		}
		return false;
	}

	// cap nhat 2
	public static void capnhat(String name, String id) {
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"update category set category_name='" + name + "' where category_id='" + id + "' ");
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Loi " + ex.getMessage());
		}
	}

	// xoa
	public boolean deleteCategory(long category_id) {
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("delete from category where category_id=?  ");
			ps.setLong(1, category_id);
			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Loi " + ex.getMessage());
		}
		return false;
	}
}
