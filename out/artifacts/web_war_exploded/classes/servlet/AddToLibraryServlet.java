package servlet;

import by.artiomN.entity.User;
import by.artiomN.entity.UserLibrary;
import by.artiomN.service.UserLibraryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddToLibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("currentUser");
        User user=(User) obj;
        Long id = Long.valueOf(req.getParameter("id"));

        UserLibraryService.INSTANCE.writeToLibrary(new UserLibrary(user.getId(),id));

        resp.sendRedirect("/user-lib");
//        getServletContext().getRequestDispatcher(createViewPath("library")).forward(req,resp);
    }
}
