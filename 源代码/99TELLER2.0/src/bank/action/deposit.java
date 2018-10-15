package bank.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class deposit
 */
@WebServlet("/bank/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");  
		String users=request.getParameter("username");  
		String sex=request.getParameter("sex"); 
		String card_sort=request.getParameter("card_sort"); 
		String card_number=request.getParameter("card_number"); 
		String bj=request.getParameter("bj"); 
		String saving_sort=request.getParameter("saving_sort"); 
		System.out.println("username "+users);
		System.out.println("password "+sex);
		System.out.println("password "+card_sort);
		System.out.println("password "+card_number);
		System.out.println("password "+bj);
		System.out.println("password "+saving_sort);
		PrintWriter print=response.getWriter();
		try{

		    JSONObject jsonObj = new JSONObject();//����json����
		    
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			int userid=(int)(Math.random()*100000);

		    try {
				jsonObj.put("userid",String.valueOf(userid));
				
		        jsonObj.put("msg","1");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    HttpSession session = request.getSession();
		    session.setAttribute("username", users);
		    print.print(jsonObj.toString());

			print.flush();
		    print.close();
			}
			catch (Exception e) 
				{ 
				e.printStackTrace();
				
				// print.print("<script>alert('ϵͳ��æ�����Ժ����ԣ�'); history.go(-1);</script>");
				} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
