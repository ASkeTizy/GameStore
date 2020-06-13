package servlet;

import by.artiomN.dto.UserBasicDto;
import by.artiomN.entity.User;
import by.artiomN.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.stream.Collectors.joining;
import static util.ServletUtil.createViewPath;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(createViewPath("login"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();

        String collect = req.getReader().lines().collect(joining("\n"));
        UserBasicDto userBasicDto = gson.fromJson(collect, UserBasicDto.class);
        //System.out.println(userBasicDto.getLogin());
        User authentication = UserService.INSTANCE.authentication(userBasicDto);
        if(authentication.getId()==1){
            resp.sendRedirect("/approve-list");
        }
        //System.out.println(authentication);
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(authentication));

        if(authentication!=null){
            req.getSession().setAttribute("currentUser",authentication);
         //   resp.sendRedirect("/game-list");
        }
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");

    }
}
