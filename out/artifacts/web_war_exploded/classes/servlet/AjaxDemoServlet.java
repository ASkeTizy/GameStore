package servlet;

import by.artiomN.dto.InputMessageDto;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.stream.Collectors.joining;
import static util.ServletUtil.createViewPath;
@WebServlet("/ajax-demo")
public class AjaxDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(createViewPath("ajax-demo")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        InputMessageDto inputMessageDto = gson.fromJson(req.getReader().lines().collect(joining("\n")), InputMessageDto.class);
        System.out.println(inputMessageDto);
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(new InputMessageDto("Succefully Done")));
    }
}
