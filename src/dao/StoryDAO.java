
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mysql.jdbc.PreparedStatement;

import connect.DBConnect;
import model.PostMua;
import model.Story;

public class StoryDAO {

	public String getCategoryById(String id) throws SQLException {
		Connection con = DBConnect.getConnection();
		java.sql.PreparedStatement ps = con.prepareStatement("select category_name from category where category_id=? ");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		String category_name = "";
		if (rs.next()) {
			category_name = rs.getString("category_name");
		}
		return category_name;
	}

	public  int countbaidangmua() throws SQLException {
		Connection con = DBConnect.getConnection();
		java.sql.PreparedStatement ps = con.prepareStatement("select*from dangtinmua ");
		int count = 0;
		ResultSet rs = ps.executeQuery();
		PostMua p = new PostMua();
		while (rs.next()) {
			p.setStt(rs.getInt("stt"));
			count++;
		}
		return count;
	}

	public  int countbaidangban() throws SQLException {
		Connection con = DBConnect.getConnection();
		java.sql.PreparedStatement ps = con.prepareStatement("select*from story ");
		int count = 0;
		ResultSet rs = ps.executeQuery();
		PostMua p = new PostMua();
		while (rs.next()) {
			p.setStt(rs.getInt("story_id"));
			count++;
		}
		return count;
	}

	public  ArrayList<Story> getListStoryByNav(long category_id, int firstResult, int maxResult)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Story> list = new ArrayList<>();
		try {
			con = DBConnect.getConnection();
			ps = (PreparedStatement) con
					.prepareStatement("select*from story where status='1' and category_id=? limit ? ,? ");
			ps.setLong(1, category_id);
			ps.setInt(2, firstResult);
			ps.setInt(3, maxResult);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Story story = new Story();
				story.setStoryId(rs.getLong(i++));
				story.setCategoryID(rs.getLong(i++));
				story.setCategoryName(rs.getString(i++));
				story.setStoryName(rs.getString(i++));
				story.setStoryImage(rs.getString(i++));
				story.setStoryDescription(rs.getString(i++));
				story.setWriterName(rs.getString(i++));
				story.setCreateDate(rs.getString(i++));
				story.setStatus(rs.getString(i++));
				list.add(story);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return list;
	}

	// tinh tong san pham cua danh muc
	public  int countStoryByCategory(long CategoryID) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = (PreparedStatement) con
				.prepareStatement("select*from story where category_id='" + CategoryID + "' ");
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
			int k = rs.getInt("story_id");
			count++;
		}
		return count;
	}

	// tim kiem theo ten bai story
	public  ArrayList<Story> getSearch(String ten) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Story> list = new ArrayList<>();
		try {
			con = DBConnect.getConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from story where story_name like '%?%' ");
			ps.setString(1, ten);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Story story = new Story();
				story.setStoryId(rs.getLong(i++));
				story.setCategoryID(rs.getLong(i++));
				story.setCategoryName(rs.getString(i++));
				story.setStoryName(rs.getString(i++));
				story.setStoryImage(rs.getString(i++));
				story.setStoryDescription(rs.getString(i++));
				story.setWriterName(rs.getString(i++));
				story.setCreateDate(rs.getString(i++));
				story.setStatus(rs.getString(i++));
				list.add(story);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return list;
	}

	// Ä�Æ°a TÃ¢t Cáº£ Sáº£n Pháº©m Tá»« Category_id ra Khi
	// báº¥m vÃ o danh má»¥c Ä‘Ã³
	public  ArrayList<Story> getListStoryByCategory(long category_id) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Story> list = new ArrayList<>();
		try {
			con = DBConnect.getConnection();
			ps = (PreparedStatement) con.prepareStatement("select*from story where category_id=? ");
			ps.setLong(1, category_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Story story = new Story();
				story.setStoryId(rs.getLong(i++));
				story.setCategoryID(rs.getLong(i++));
				story.setCategoryName(rs.getString(i++));
				story.setStoryName(rs.getString(i++));
				story.setStoryImage(rs.getString(i++));
				story.setStoryDescription(rs.getString(i++));
				story.setWriterName(rs.getString(i++));
				story.setCreateDate(rs.getString(i++));
				story.setStatus(rs.getString(i++));
				list.add(story);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return list;

	}

	// hiá»ƒn thá»‹ chi tiáº¿t sáº£n pháº©m
	public  Story getStory(long storyId) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Story story = new Story();
		try {
			con = DBConnect.getConnection();
			ps = (PreparedStatement) con.prepareStatement("SELECT*FROM story WHERE story_id=? ");
			ps.setLong(1, storyId);
			rs = ps.executeQuery();
			if (rs.next()) {
				int i = 1;
				story.setStoryId(rs.getLong(i++));
				story.setCategoryID(rs.getLong(i++));
				story.setCategoryName(rs.getString(i++));
				story.setStoryName(rs.getString(i++));
				story.setStoryImage(rs.getString(i++));
				story.setStoryDescription(rs.getString(i++));
				story.setWriterName(rs.getString(i++));
				story.setCreateDate(rs.getString(i++));
				story.setStatus(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return story;

	}

	/*
	 * public  ArrayList<Story> getstorySamePrice(Double d) throws
	 * SQLException { Connection con = DBConnect.getConnection(); Double d1 = d
	 * - 0.6; Double d2 = d + 0.6; java.sql.PreparedStatement ps =
	 * con.prepareStatement( "SELECT*FROM story WHERE story_price >= '" + d1
	 * + "' and story_price<='" + d2 + "' limit 6"); ResultSet rs =
	 * ps.executeQuery();
	 * 
	 * ArrayList<Story> list = new ArrayList<>(); while (rs.next()) { Story p =
	 * new Story(); p.setstoryID(rs.getLong("story_id"));
	 * p.setstoryName(rs.getString("story_name"));
	 * p.setstoryImage(rs.getString("story_image"));
	 * p.setstoryPrice(rs.getDouble("story_price"));
	 * p.setstoryDescription(rs.getString("story_description"));
	 * p.setSdt(rs.getString("story_sdt"));
	 * p.setHinhthuc(rs.getString("story_hinhthuc"));
	 * p.setDientich(rs.getDouble("story_dientich"));
	 * p.setHoten(rs.getString("story_hoten"));
	 * p.setVitri(rs.getString("story_vitri")); p.setNgaydang(new
	 * SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("story_ngaydang")));
	 * list.add(p); } return list; }
	 */

	public  ArrayList<Story> getStorySameTieuDe(String tieude) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Story> list = new ArrayList<>();
		try {
			con = DBConnect.getConnection();
			ps = (PreparedStatement) con.prepareStatement("Select*from story where story_name like '%"+tieude+"%' limit 6 ");
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Story story = new Story();
				story.setStoryId(rs.getLong(i++));
				story.setCategoryID(rs.getLong(i++));
				story.setCategoryName(rs.getString(i++));
				story.setStoryName(rs.getString(i++));
				story.setStoryImage(rs.getString(i++));
				story.setStoryDescription(rs.getString(i++));
				story.setWriterName(rs.getString(i++));
				story.setCreateDate(rs.getString(i++));
				story.setStatus(rs.getString(i++));
				list.add(story);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return list;

	}

	// hien thi tat ca san pham
	public  ArrayList<Story> getListStory() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Story> list = new ArrayList<>();
		try {
			con = DBConnect.getConnection();
			ps = (PreparedStatement) con.prepareStatement("select*from story where status='1'");
			rs = ps.executeQuery();
			while (rs.next()) {
				int i = 1;
				Story story = new Story();
				story.setStoryId(rs.getLong(i++));
				story.setCategoryID(rs.getLong(i++));
				story.setCategoryName(rs.getString(i++));
				story.setStoryName(rs.getString(i++));
				story.setStoryImage(rs.getString(i++));
				story.setStoryDescription(rs.getString(i++));
				story.setWriterName(rs.getString(i++));
				story.setCreateDate(rs.getString(i++));
				story.setStatus(rs.getString(i++));
				list.add(story);
			}
			Collections.sort(list, new Comparator<Story>() {
				@Override
				public int compare(Story t, Story t1) {
					return t1.getCreateDate().compareTo(t.getCreateDate());
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return list;

	}
}
