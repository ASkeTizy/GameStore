package servlet;

import by.artiomN.entity.User;
import by.artiomN.service.UserLibraryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;
@WebServlet("/user-lib")
public class UserLibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("currentUser");
        User user=(User) obj;
        req.setAttribute("games",UserLibraryService.INSTANCE.getUserListOfGames(user.getId()));
        getServletContext().getRequestDispatcher(createViewPath("library")).forward(req,resp);
    }


}
