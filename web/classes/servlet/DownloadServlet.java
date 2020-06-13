package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/download-file")
public class DownloadServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String fileName="heroes-of-might-and-magic-3-complete.torrent";
        String filePath="D:\\work\\";
        resp.setContentType("APPLICATION/OCTET-STREAM");
        resp.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
        FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
        int i;
        while ((i=fileInputStream.read())!=-1){
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
