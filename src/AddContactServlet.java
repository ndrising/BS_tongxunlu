import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        Contact newContact = new Contact(name, address, phone);
        ViewContactsServlet.getContacts().add(newContact);

        response.sendRedirect("view_contacts");
    }
}
