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


    @WebServlet(urlPatterns = "/full-approve",name = "ApproveGameInfo")
    public class ApproveGameServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Long id = Long.valueOf(req.getParameter("id"));
            System.out.println(id);
            Game game=GameService.INSTANCE.getGame(id);
            System.out.println(game.getName());
            req.setAttribute("game",game);





                GameService.INSTANCE.createGame(game);
                //System.out.println(aLong);
            getServletContext()
                    .getRequestDispatcher(createViewPath("full-approve"))
                    .forward(req,resp);

        }

}
