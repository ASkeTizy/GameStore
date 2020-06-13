package servlet;

import by.artiomN.entity.Game;
import by.artiomN.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/saveGame", name = "CreateGame")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class SaveGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("genres",GenreService.INSTANCE.getAllGenres());
        getServletContext().getRequestDispatcher(createViewPath("save-game"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String realPath = getServletContext().getRealPath("") + File.separator + "D:\\work\\";
//        File file = new File(realPath);
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        String fileName="";
//        for (Part part : req.getParts()) {
//            fileName = part.getSubmittedFileName();
//            part.write(realPath + File.separator + fileName);
//        }
//        System.out.println(fileName);
       // req.setAttribute("message", "File " + fileName + " has uploaded successfully!");

        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        String companyName = req.getParameter("companyName");

        if (!name.isEmpty() && !genre.isEmpty() && !companyName.isEmpty()) {

            Game game = new Game(name, genre, companyName);

            //Long aLong = GameService.INSTANCE.createGame(game);
            //System.out.println(aLong);
            GameService.INSTANCE.addToList(game);
           // resp.sendRedirect("/full-info?id=" + GameService.INSTANCE.createGame(game));
            resp.sendRedirect("/game-list");
        } else {
            resp.sendRedirect("/saveGame");
        }
    }

}
