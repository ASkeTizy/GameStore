package servlet;

import by.artiomN.entity.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.stream.Collectors.joining;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    public static final String ATTR_NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();

        String collect = req.getReader().lines().collect(joining("\n"));
        User user = gson.fromJson(collect, User.class);
        System.out.println(user.toString());

    }
}
