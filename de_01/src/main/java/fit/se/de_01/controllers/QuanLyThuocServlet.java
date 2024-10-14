package fit.se.de_01.controllers;

import fit.se.de_01.daos.QuanlyLoaiThuocDao;
import fit.se.de_01.daos.QuanlyThuocDao;
import fit.se.de_01.models.LoaiThuoc;
import fit.se.de_01.models.Thuoc;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
@WebServlet(name = "QuanLyThuocServlet", value = "/controller")
public class QuanLyThuocServlet extends HttpServlet {
   @EJB
   private QuanlyLoaiThuocDao quanlyLoaiThuoc;
   @EJB
   private QuanlyThuocDao quanlyThuoc;


   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action");
      if (action.equalsIgnoreCase("get-ds-loai-thuoc")) {
         req.setAttribute("ds-loai-thuoc", quanlyLoaiThuoc.getLoaiThuocs());
         req.getRequestDispatcher("ds-loai-thuoc.jsp").forward(req, resp);
      } else if (action.equalsIgnoreCase("get-ds-thuoc")) {
         req.setAttribute("ds-thuoc", quanlyThuoc.getThuocs());
         req.getRequestDispatcher("ds-thuoc.jsp").forward(req, resp);
      } else if (action.equalsIgnoreCase("them-thuoc")) {
         req.setAttribute("ds-loai-thuoc", quanlyLoaiThuoc.getLoaiThuocs());
         req.getRequestDispatcher("them-thuoc.jsp").forward(req, resp);
      } else if (action.equalsIgnoreCase("get-ds-thuoc-by-loai")) {
         String maLoaiThuoc = req.getParameter("ma-loai");
         req.setAttribute("ds-thuoc", quanlyLoaiThuoc.getThuocsByLoai(maLoaiThuoc));
         req.getRequestDispatcher("ds-thuoc.jsp").forward(req, resp);
      } else {
         resp.sendRedirect("error.jsp");
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action");
      if (action.equalsIgnoreCase("them-thuoc")) {
         String tenThuoc = req.getParameter("ten-thuoc");
         String donGia = req.getParameter("gia-ban");
         String namSX = req.getParameter("nam-sx");
         String maLoaiThuoc = req.getParameter("loai-thuoc");
         Optional<LoaiThuoc> loaiThuoc = quanlyLoaiThuoc.getLoaiThuoc(maLoaiThuoc);
         if (loaiThuoc.isEmpty()) {
            throw new RuntimeException("Loại thuốc không tồn tại");
         }
         try {
            Double.parseDouble(donGia);
            Integer.parseInt(namSX);
         } catch (NumberFormatException e) {
            throw new RuntimeException("Giá bán hoặc năm sản xuất không hợp lệ");
         }
         Thuoc thuoc = new Thuoc(
               UUID.randomUUID().toString(),
               tenThuoc,
               Double.parseDouble(donGia),
               Integer.parseInt(namSX),
               loaiThuoc.get()
         );
         quanlyThuoc.addThuoc(thuoc);
         req.setAttribute("ds-thuoc", quanlyThuoc.getThuocs());
         req.getRequestDispatcher("ds-thuoc.jsp").forward(req, resp);
      } else {
         resp.sendRedirect("error.jsp");
      }
   }
}
