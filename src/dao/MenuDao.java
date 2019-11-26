package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.Menu;

public class MenuDao {
	public List<Menu> getLstMenu() throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		List<Menu> lstMenu = new ArrayList<>();
		try {
			sql = "SELECT * FROM MENU WHERE STATUS=1 ORDER BY ORDER_NUMBER ASC ";
			conn = DBConnect.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int i = 1;
				Menu menu = new Menu();
				menu.setId(rs.getLong(i++));
				menu.setMenuName(rs.getString(i++));
				menu.setLinkMenu(rs.getString(i++));
				menu.setStatus(rs.getInt(i++));
				menu.setOrderNumber(rs.getInt(i++));
				lstMenu.add(menu);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return lstMenu;
	}
}
