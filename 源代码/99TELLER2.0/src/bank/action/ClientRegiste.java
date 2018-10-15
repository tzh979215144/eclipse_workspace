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

import com.lm.activemq.Sender;

/**
 * Servlet implementation class ClientRegiste
 */
@WebServlet("/bank/ClientRegiste")
public class ClientRegiste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");  
		String users=request.getParameter("username");  
		String sex=request.getParameter("sex"); 
		String card_sort=request.getParameter("card_sort"); 
		String card_number=request.getParameter("card_number"); 
		String bj=request.getParameter("bj"); 
		String saving_sort=request.getParameter("saving_sort"); 
		if(sex.equals("1")) {
			sex="男";
		}else {
			sex="女";
		}
		if (saving_sort.equals("HUO")){
			saving_sort="活期";
		}else {
			saving_sort="定期";
		}
		if (card_sort.equals("identity_card")){
			card_sort="身份证";
		}else if(card_sort.equals("military_card")){
			card_sort="军人证";
		}else {
			card_sort="护照";
		}
		StringBuilder str =new StringBuilder();
		str.append("姓名: "+users+"\t\t\t"+"性别: "+sex+"\n");
		str.append("证件类型: "+card_sort+"\t\t"+"证件号: "+card_number+"\n");
		str.append("币种: "+bj+"\t\t\t"+"储蓄类型: "+saving_sort+"\n");
		Sender.sendOaa(str.toString());
		
		
		PrintWriter print=response.getWriter();
		try{

		    JSONObject jsonObj = new JSONObject();
		    
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
				} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
