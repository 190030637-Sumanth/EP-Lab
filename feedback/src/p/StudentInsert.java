package p;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInsert
 */
public class StudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentInsert() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("user");
		String e=request.getParameter("email");
		String g=request.getParameter("gender");
		String p=request.getParameter("password");
	    Bean b=new Bean();
		DAO d=new DAO();
		b.setUsername(u);
		b.setEmail(e);
		b.setGender(g);
		b.setPassword(p);
		PrintWriter pw=response.getWriter();
		int at=-1;
		at=e.indexOf('@');
		int dot=-1;
		dot=e.lastIndexOf('.');
		int a=0;
		if(g==null||g=="")
		{
		a=1;
		}
		if(u==null||u=="")
		{
		a=1;
		}
		else if(u.length()<8)
		{
		a=1;
		}
		if(e==null||e=="")
		{
		a=1;
		}
		else if(at<1||dot<at||dot-at==1||e.length()-dot<3)
		{
		a=1;
		}
		if(p==null||p=="")
		{
		a=1;
		}
		else if(p.length()<8)
		{
		a=1;
		}
		if(a==0)
		{
		  try {
			   int i=d.insert(b);
			   if(i>0) {
			    pw.print("Hello "+u+"values are inserted in table");
			   }else {
				pw.print("Sorry "+u+"values are note inserted");
			   }			
		      } catch (SQLException e1) {
			           e1.printStackTrace();
		      } catch (ClassNotFoundException e1) {
			           // TODO Auto-generated catch block
			           e1.printStackTrace();
	       	  }
		}
		else {
		    pw.print("enter valid details");
		}
	}

}
