import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ViewContactsServlet extends HttpServlet {
    private static List<Contact> contacts = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>通讯录</title></head><body>");
        out.println("<h2>联系人列表</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>姓名</th><th>住址</th><th>电话</th></tr>");
        for (Contact contact : contacts) {
            out.println("<tr>");
            out.println("<td>" + contact.getName() + "</td>");
            out.println("<td>" + contact.getAddress() + "</td>");
            out.println("<td>" + contact.getPhone() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<a href='add_contact.html'>添加联系人</a><br>");
        out.println("<a href='modify_contact.html'>修改联系人</a><br>");
        out.println("<a href='delete_contact.html'>删除联系人</a><br>");
        out.println("</body></html>");
    }

    public static List<Contact> getContacts() {
        return contacts;
    }
}
