import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ModifyContactServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");

        String newName = request.getParameter("newName");
        String newAddress = request.getParameter("newAddress");
        String newPhone = request.getParameter("newPhone");

        List<Contact> contacts = ViewContactsServlet.getContacts();
        boolean contactFound = false;

        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                if (newName != null && !newName.isEmpty()) {
                    contact.setName(newName);
                }
                if (newAddress != null && !newAddress.isEmpty()) {
                    contact.setAddress(newAddress);
                }
                if (newPhone != null && !newPhone.isEmpty()) {
                    contact.setPhone(newPhone);
                }
                contactFound = true;
                break;
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>修改联系人结果</title></head><body>");
        if (contactFound) {
            out.println("<h2>联系人信息修改成功！</h2>");
        } else {
            out.println("<h2>未找到指定的联系人。</h2>");
        }
        out.println("<a href='view_contacts'>返回联系人列表</a>");
        out.println("</body></html>");
    }
}
