
package de.vogella.wtp.filecounter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JavaScript
 */
public class JavaScript extends FileCounter {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			// Set the session valid for 10 minutes
			session.setMaxInactiveInterval(1);
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			if (session.isNew()) {
				count++;
			}
			String s = "br.writeln(\"This site has been accessed "+ "<B>" + count +"</B><BR>"+"\");"; 
			out.println("var br=document;");
			out.println(s);
	}
}
