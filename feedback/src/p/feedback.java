package p;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class feedback
 */
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("name");
		String f=request.getParameter("fback");
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		try {
			int i=d.insert_fback(n, f);
			if(i>0)
			{
				pw.print("hey "+n+" your feedback is submitted");
			}
			else
			{
				pw.print("sorry "+n+" values are not inserted");
			}
		} catch (ClassNotFoundException e) {
			pw.print("sorry "+n+" values are not inserted");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pw.print("sorry "+n+" values are not inserted");
			e.printStackTrace();
		}
	}

}
