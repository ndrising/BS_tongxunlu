import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");

        ViewContactsServlet.getContacts().removeIf(contact -> contact.getName().equals(name));

        response.sendRedirect("view_contacts");
    }
}
