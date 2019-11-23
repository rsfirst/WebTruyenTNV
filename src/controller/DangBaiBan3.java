package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "DangBaiBan3", urlPatterns = {"/DangBaiBan3"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class DangBaiBan3 extends HttpServlet {

    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/muabannhadat";
    private String dbUser = "root";
    private String dbPass = "admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String tieude = request.getParameter("tieude");
        String gia = request.getParameter("gia");
        String ht = request.getParameter("ht");
        String sdt = request.getParameter("sdt");
        String dt = request.getParameter("dt");
        String vt = request.getParameter("vt");
        String mota = request.getParameter("mota");
        String category_id = request.getParameter("category_id");
        Date d = new Date();
        d.getTime();
        SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
        String qq = sff.format(d);
        String hinhthuc = request.getParameter("hinhthuc");
        String hinhthucfor = "";
        if (hinhthuc.equals("6")) {
            hinhthucfor = "Nhà Bán";
        } else if (hinhthuc.equals("7")) {
            hinhthucfor = "Đất Bán";
        } else if (hinhthuc.equals("8")) {
            hinhthucfor = "Cho Thuê Nhà";
        } else if (hinhthuc.equals("9")) {
            hinhthucfor = "Cho Thuê Đất";
        }

        int k = 0;
        if (category_id.equals("1")) {
            k = 1;
        } else if (category_id.equals("2")) {
            k = 2;
        } else if (category_id.equals("3")) {
            k = 3;
        } else if (category_id.equals("4")) {
            k = 4;
        } else {
            k = 5;
        }
        Part filePart = request.getPart("file");
        String fileName = extractFileName(filePart);
        String savePath = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\MuaBanNha\\web\\images" + File.separator + fileName;
        File fileSaveDir = new File(savePath);
        filePart.write(savePath + File.separator);

        try 
        {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "INSERT INTO product (category_id, product_name, product_image,product_price,product_description,"
                    + "product_sdt,product_dientich,product_hoten,product_vitri,product_ngaydang,product_hinhthuc) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, k);
            statement.setString(2, tieude);
            statement.setString(3, "images" + "/" + fileName);
            statement.setDouble(4, Double.parseDouble(gia));
            statement.setString(5, mota);
            statement.setString(6, sdt);
            statement.setDouble(7, Double.parseDouble(dt));
            statement.setString(8, ht);
            statement.setString(9, vt);
            statement.setString(10, qq);
            statement.setString(11, hinhthucfor);
            if (statement.executeUpdate() == 1)
            {
                request.setAttribute("dangbaiban", "Đã Đăng Bài Bán");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 

    }

    private String extractFileName(Part part) {
        String contenDisp = part.getHeader("content-disposition");
        String[] items = contenDisp.split(";");
        for (String s : items) 
        {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
