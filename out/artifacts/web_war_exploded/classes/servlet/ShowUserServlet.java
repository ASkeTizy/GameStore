package servlet;

import by.artiomN.entity.User;
import by.artiomN.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/user")
public class ShowUserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id =Long.valueOf(req.getParameter("id")) ;
        User foundUser = UserService.INSTANCE.findOne(id);
        req.setAttribute("user",foundUser);
        getServletContext()
                .getRequestDispatcher(createViewPath("show-user"))
                .forward(req,resp);
    }
}
