package fit.se.de_03.resources;

import fit.se.de_03.daos.QuanlyXeDAO;
import fit.se.de_03.entities.Xe;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 23/10/24
 */
@Path("/xe")
public class XeResource {
   @EJB
   private QuanlyXeDAO quanlyXeDAO;

   @GET
   @Produces("application/json")
   public List<Xe> findAll() {
      return quanlyXeDAO.findAll();
   }

   @GET
   @Path("/{id}")
   public Xe findById(@PathParam("id") String id) {
      try {
         return quanlyXeDAO.findById(Long.parseLong(id)).get();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   @GET
   @Path("/loai-xe/{maLoai}")
   @Produces("application/json")
   public List<Xe> findByLoaiXe(@PathParam("maLoai") int maLoai) {
      try {
         return quanlyXeDAO.findByLoaiXe((long) maLoai);
      } catch (Exception e) {
         e.printStackTrace();
         return List.of();
      }
   }
}
