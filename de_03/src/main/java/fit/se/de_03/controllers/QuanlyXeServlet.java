package fit.se.de_03.controllers;

import fit.se.de_03.daos.QuanlyLoaiXeDAO;
import fit.se.de_03.daos.QuanlyXeDAO;
import fit.se.de_03.entities.Xe;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description
 * @author: vie
 * @date: 23/10/24
 */
@WebServlet(name = "QuanlyXeServlet", value = "/quanly-xe")
public class QuanlyXeServlet extends HttpServlet {
   @EJB
   private QuanlyXeDAO quanlyXeDAO;
   @EJB
   private QuanlyLoaiXeDAO quanlyLoaiXeDAO;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action");
      switch (action) {
         case "danh-sach-loai-xe" -> {
            req.setAttribute("listLoaiXe", quanlyLoaiXeDAO.findAll());
            req.getRequestDispatcher("danh-sach-loai-xe.jsp").forward(req, resp);
         }
         case "danh-sach-xe-theo-loai-xe" -> {
            String loaiXe = req.getParameter("loai-xe");
            try {
               Long idLoaiXe = Long.parseLong(loaiXe);
               req.setAttribute("listXe", quanlyXeDAO.findByLoaiXe(idLoaiXe));
               req.getRequestDispatcher("danh-sach-xe-theo-loai-xe.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
               resp.sendRedirect("error.jsp");
            }
         }
         default -> {
            resp.sendError(404, "Không tìm thấy action");
         }
      }
   }


   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action");
      switch (action) {
         case "them-xe" -> {
            try {
               String tenXe = req.getParameter("ten-xe");
               String gia = req.getParameter("gia");
               String namSx = req.getParameter("nam-sx");
               String loaiXe = req.getParameter("loai-xe");
               double giaXe = Double.parseDouble(gia);
               int namSanXuat = Integer.parseInt(namSx);
               Xe xe = new Xe(tenXe, giaXe, namSanXuat);
               quanlyLoaiXeDAO.findById(Long.parseLong(loaiXe))
                     .ifPresentOrElse(xe::setLoaiXe,
                           () -> {
                              try {
                                 resp.sendError(404, "Loại xe không tồn tại");
                              } catch (IOException e) {
                                 throw new RuntimeException(e);
                              }
                           });
               quanlyXeDAO.save(xe);
               resp.sendRedirect("index.jsp");
            } catch (Exception e) {
               resp.sendError(500, e.getMessage());
            }
         }
      }
   }
}