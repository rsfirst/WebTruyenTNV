/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ChoThue;
import dao.DuyetBaiDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "DuyetBai", urlPatterns = {"/DuyetBai"})
public class DuyetBai extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String ChoThueID = request.getParameter("ChoThueID");
        String url = "";
        ChoThue c = null;
        try {
            c = DuyetBaiDAO.getChoThue(Integer.parseInt(ChoThueID));
        } catch (SQLException ex) {
            System.out.println("Lỗi " + ex.getMessage());
        }

        switch (command) {
            case "duyet": {
                try {
                    if (DuyetBaiDAO.ChapNhanBaiDang(Integer.parseInt(ChoThueID))) {
                        request.setAttribute("daduyet", "Đã Duyệt Bài Của " + c.getChothue_hoten());
                        url = "/manager_product_chothue.jsp";
                        break;
                    } else {
                        url = "/MoHinh.jsp";
                        break;
                    }
                } catch (SQLException ex) {
                    System.out.println("Lỗi" + ex.getMessage());
                }
            }
            case "xoa": {
                try {
                    if (DuyetBaiDAO.xoaBaiDang(Integer.parseInt(ChoThueID))) {
                        request.setAttribute("xoa", "Đã Xóa Bài Của " + c.getChothue_hoten());
                        url = "/manager_product_chothue.jsp";
                        break;
                    } else {
                        url = "/MoHinh.jsp";
                        break;
                    }
                } catch (SQLException ex) {
                    System.out.println("Lỗi" + ex.getMessage());
                }
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
