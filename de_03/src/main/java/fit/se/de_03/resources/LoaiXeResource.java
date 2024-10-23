package fit.se.de_03.resources;

import fit.se.de_03.daos.QuanlyLoaiXeDAO;
import fit.se.de_03.entities.LoaiXe;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 23/10/24
 */
@Path("/loai-xe")
public class LoaiXeResource {
   @EJB
   private QuanlyLoaiXeDAO loaiXeDAO;

   @GET
   @Produces("application/json")
   public List<LoaiXe> findAll() {
      return loaiXeDAO.findAll();
   }
}
