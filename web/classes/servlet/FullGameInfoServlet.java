package servlet;

import by.artiomN.entity.Game;
import by.artiomN.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/full-info",name = "FullGameInfo")
public class FullGameInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        Game game = GameService.INSTANCE.findOne(id);
        req.setAttribute("game",game);
        getServletContext()
                .getRequestDispatcher(createViewPath("full-info"))
                .forward(req,resp);
    }
}
