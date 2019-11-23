package controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/DangBaiBan2")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class DangBaiBan2 extends HttpServlet {

    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/muabannhadat";
    private String dbUser = "root";
    private String dbPass = "admin";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // gets values of text fields
        String tieude = request.getParameter("tieude");
        String gia = request.getParameter("gia");
        String ht = request.getParameter("ht");
        String sdt = request.getParameter("sdt");
        String dt = request.getParameter("dt");
        String vt = request.getParameter("vt");
        String mota = request.getParameter("mota");
        String category_id = request.getParameter("category_id");
        int k =  0;
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
        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        String fileName =  extractFileName(filePart);
        String savePath = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\MuaBanNha\\web\\images" + File.separator +fileName ;
        File fileSaveDir = new File(savePath);
        filePart.write(savePath +File.separator );
        
        if (filePart != null) 
        {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            // constructs SQL statement
            String sql = "INSERT INTO product (category_id, product_name, product_image,product_price,product_description,"
                    + "product_sdt,product_dientich,product_hoten,product_vitri) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, k);
            statement.setString(2, tieude);
            // fetches input stream of the upload file for the blob column
            statement.setString(3,"images"+"'\'"+ fileName );
            statement.setDouble(4, Double.parseDouble(gia));
            statement.setString(5, mota);
            statement.setString(6, sdt);
            statement.setDouble(7, Double.parseDouble(dt));
            statement.setString(8, ht);
            statement.setString(9, vt);
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {

            // forwards to the message page
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    private String extractFileName(Part part)
    {
        String contenDisp = part.getHeader("content-disposition");
        String[] items = contenDisp.split(";");
        for(String s:items)
        {
            if(s.trim().startsWith("filename"))
            {
                return s.substring(s.indexOf("=") +2, s.length()-1 );
            }
        }
        return "";
    }
}