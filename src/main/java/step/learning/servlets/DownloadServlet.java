package step.learning.servlets;

import step.learning.services.MimeService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@Singleton
public class DownloadServlet extends HttpServlet {

    @Inject private MimeService mimeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedFileName = req.getPathInfo();

        int dotPosition = requestedFileName.lastIndexOf(".");
        if(dotPosition == -1) {
            resp.setStatus(400);
            resp.getWriter().print(requestedFileName + ": File extension required");
            return;
        }

        String extension = requestedFileName.substring( dotPosition ) ;
        String mimeType = mimeService.getMimeByExtension( extension ) ;
        if( mimeType == null ) {
            resp.setStatus( 400 ) ;
            resp.getWriter().print( requestedFileName + ": File extension unsupported" ) ;
            return ;
        }

        String path = req.getServletContext().getRealPath("/");
        File file = new File(path + "../upload" + requestedFileName);

        if(file.isFile()) {
            resp.setContentType(mimeType);
            resp.setContentLengthLong(file.length());
            try (InputStream reader = Files.newInputStream(file.toPath())){
                byte[] buff = new byte[1024];
                int n;
                OutputStream writer = resp.getOutputStream();
                while( (n = reader.read(buff)) > 0 ) {
                    writer.write(buff, 0, n);
                }
            }
            catch (IOException ex) {
                System.out.println("DownloadServlet::doGet " + requestedFileName + "\n" + ex.getMessage());
                resp.setStatus(500);
                resp.getWriter().println("ServerError");
            }
        }
        else {
            resp.setStatus(404);
            resp.getWriter().println(requestedFileName + " not found");
        }
    }
}
