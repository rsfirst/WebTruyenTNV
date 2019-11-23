
package controller;

import dao.ChoThueDAO;
import java.io.File;
import java.io.IOException;
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

/**
 *
 * @author Administrator
 */

@WebServlet(name = "ChoThue", urlPatterns = {"/ChoThue"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class ChoThue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            String loainhadat = request.getParameter("loainhadat");
            String loainhatdatt = "";
            if (loainhadat.equals("1")) {
                loainhatdatt = "Cho thuê căn hộ chung cư";
            } else if (loainhadat.equals("2")) {
                loainhatdatt = "Cho thuê nhà riêng";
            } else if (loainhadat.equals("3")) {
                loainhatdatt = "Cho thuê nhà mặt phố";
            } else if (loainhadat.equals("4")) {
                loainhatdatt = "Cho thuê nhà trọ,phòng trọ";
            } else if (loainhadat.equals("5")) {
                loainhatdatt = "Cho thuê văn phòng";
            } else if (loainhadat.equals("6")) {
                loainhatdatt = "Cho thuê cửa hàng,ki ốt";
            } else if (loainhadat.equals("7")) {
                loainhatdatt = "Cho thuê nhà kho";
            } else {
                loainhatdatt = "Cho thuê nhà xưởng,đất";
            }
            Double gia = Double.parseDouble(request.getParameter("gia"));
            Double dientich = Double.parseDouble(request.getParameter("dientich"));
            String diadiem = request.getParameter("diadiem");
            Double matien = Double.parseDouble(request.getParameter("matien"));
            Double duongtruocnha = Double.parseDouble(request.getParameter("duongtruocnha"));
            String huongnha = request.getParameter("huongnha");
            String huongnhaa = "";
            if (huongnha.equals("1")) {
                huongnhaa = "Đông";
            } else if (huongnha.equals("2")) {
                huongnhaa = "Tây";
            } else if (huongnha.equals("3")) {
                huongnhaa = "Nam";
            } else if (huongnha.equals("4")) {
                huongnhaa = "Bắc";
            } else if (huongnha.equals("5")) {
                huongnhaa = "Đông-Bắc";
            } else if (huongnha.equals("6")) {
                huongnhaa = "Tây-Bắc";
            } else if (huongnha.equals("7")) {
                huongnhaa = "Tây-Nam";
            } else if (huongnha.equals("8")) {
                huongnhaa = "Đông-Nam";
            }else
            {
                huongnhaa ="Không Xác Định";
            }
            Double sotang = Double.parseDouble(request.getParameter("sotang"));
            int sophong = Integer.parseInt(request.getParameter("sophong"));
            int sotoilet = Integer.parseInt(request.getParameter("sotoilet"));
            String tieude = request.getParameter("tieude");
            String mota = request.getParameter("mota");
            
            Part filePart = request.getPart("hinhanh");
            String fileName = extractFileName(filePart);
            String savePath = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\MuaBanNha\\web\\images" + File.separator + fileName;
            File fileSaveDir = new File(savePath);
            filePart.write(savePath + File.separator);
            
            
            String hoten = request.getParameter("hoten");
            String diachi = request.getParameter("diachi");
            String dienthoai = request.getParameter("dienthoai");
            String email = request.getParameter("email");

            model.ChoThue c = new model.ChoThue();
            c.setChothue_loainhadat(loainhatdatt);
            c.setChothue_gia(gia);
            c.setChothue_dientich(dientich);
            c.setChothue_diadiem(diadiem);
            c.setChothue_matien(matien);
            c.setChothue_duongtruocnha(duongtruocnha);
            c.setChothue_huongnha(huongnhaa);
            c.setChothue_sotang(sotang);
            c.setChothue_sophong(sophong);
            c.setChothue_sotoilet(sotoilet);
            c.setChothue_tieude(tieude);
            c.setChothue_mota(mota);
            c.setChothue_hinhanh("images/" + fileName);
            c.setChothue_hoten(hoten);
            c.setChothue_diachi(diachi);
            c.setChothue_dienthoai(dienthoai);
            c.setChothue_email(email);
            c.setChothue_status(0);
            c.setChothue_ngaydang(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
            
            if (ChoThueDAO.insert_chothue(c)) 
            {
                request.setAttribute("chothue", "Đang Đợi Admin Phê Duỵệt");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("chothue.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi " + ex.getMessage());
        }

    }

    private String extractFileName(Part part) {
        String contenDisp = part.getHeader("content-disposition");
        String[] items = contenDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
