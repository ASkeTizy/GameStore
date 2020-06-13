package servlet;

import by.artiomN.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/game-list",name = "GamesList")
public class GameListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("games",GameService.INSTANCE.getAllGames());
        getServletContext().getRequestDispatcher(createViewPath("games-list")).forward(req,resp);
    }
}
