package fit.se.de_02.controllers;

import fit.se.de_02.models.Candidate;
import fit.se.de_02.services.CandidateService;
import fit.se.de_02.services.ExperienceService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
   @EJB
   private CandidateService candidateService;
   @EJB
   private ExperienceService experienceService;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action");
      if (action.equalsIgnoreCase("candidate")) {
         req.setAttribute("candidates", candidateService.findAll());
         req.getRequestDispatcher("candidates.jsp").forward(req, resp);
      } else if (action.equalsIgnoreCase("candidate_details")) {
         String id = req.getParameter("id");
         try {
            Optional<Candidate> candidate = candidateService.find(Long.parseLong(id));
            if (candidate.isPresent()) {
               req.setAttribute("candidate", candidate.get());
               req.getRequestDispatcher("candidate_details.jsp").forward(req, resp);
               return;
            }
            req.setAttribute("error", "Candidate not found");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
         } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Invalid candidate id");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
         }

      } else if (action.equalsIgnoreCase("report1")) {
         String role = req.getParameter("role");
         List<Candidate> candidates = candidateService.findByRole(role);
         req.setAttribute("candidates", candidates);
         req.getRequestDispatcher("report1.jsp").forward(req, resp);
      }
      else if (action.equalsIgnoreCase("report2")) {
         List<Candidate> candidates = candidateService.findCandidateUsingGmail();
         req.setAttribute("candidates", candidates);
         req.getRequestDispatcher("report2.jsp").forward(req, resp);
      }
      else {
         req.setAttribute("error", "Invalid action");
         req.getRequestDispatcher("error.jsp").forward(req, resp);
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      super.doPost(req, resp);
   }
}
