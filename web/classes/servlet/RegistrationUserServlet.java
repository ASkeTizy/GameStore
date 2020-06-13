package servlet;

import by.artiomN.dto.UserDto;
import by.artiomN.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/registration")
public class RegistrationUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(createViewPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        if (!login.isEmpty() && !password.isEmpty()) {
            UserDto userDto = createNewUserDto(req, login, password);
            Long id = UserService.INSTANCE.createUser(userDto);
            req.getSession().setAttribute("currentUser", UserService.INSTANCE.findOne(id));
            resp.sendRedirect("/game-list");

        } else {
            resp.sendRedirect("/registration");
        }
    }

    private UserDto createNewUserDto(HttpServletRequest req, String login, String password) {
        return new UserDto(login, password, req.getParameter("first_name"), req.getParameter("last_name"), Integer.valueOf(req.getParameter("age")), req.getParameter("gender"));
    }
}
