package lyons.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Login;

public class HandleGood extends HttpServlet
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 97434567L;

    /**
     * Constructor of the object.
     */
    public HandleGood()
    {
        super();
    }
    
    /**
     * Destruction of the servlet. <br>
     */
    public void destroy()
    {
        super.destroy(); 
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
       doPost(request, response);
    }
    

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
    	//这两句一定要在最前面使用，不能先用request，不然设置失效
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String value = "";
        value = request.getParameter("key");
        int key = Integer.parseInt(value);
        
       
        HttpSession session = request.getSession(true);
        Login loginBean = (Login)session.getAttribute("loginBean");
        String user = "";
        user = loginBean.getUsername();//登陆者的用户名
        if(!user.equals("master")) {
        	PrintWriter out = response.getWriter();
            out.print("<br><br><br>");
            out.print("<center><font size=5 color=red><B>"+user+"</B></font>&nbsp;无权修改商品信息");
            out.print("<br><br><br>");
            out.print("<a href=/gouwuche/jsp/browse/showGoods.jsp>返回继续购物</a>");
            out.print("&nbsp;or&nbsp;");
            out.print("<a href=/gouwuche/jsp/shoppingCar/lookShoppingCar.jsp>查看购物车</a></center>"); 	
        }
        Connection        conn  = null;
        PreparedStatement pstmtCommodity = null;
        conn = DbConn.getConn();
        
        if(key==1) {			//修改商品===================
        	String[] goods = null;
        	goods = request.getParameter("GoodsControl").split(",");
        	String sql= "UPDATE commodity SET commodity_name=?,commodity_made=?,"
        			+ "commodity_price=?,commodity_balance=? where commodity_number="+goods[0];
            try {
				pstmtCommodity = conn.prepareStatement(sql);
				//name
				String commodity_name= null;
				commodity_name = goods[1];
				pstmtCommodity.setString(1,commodity_name); 
				//made
				String commodity_made = null;
				commodity_made = goods[2];
				pstmtCommodity.setString(2,commodity_made);
				//price
				Double commodity_price = 0.00;
				commodity_price = Double.parseDouble(goods[3]);
				pstmtCommodity.setDouble(3,commodity_price); 
				//num
				int commodity_balance = -1;
				commodity_balance = Integer.parseInt(goods[4]);
				pstmtCommodity.setDouble(4,commodity_balance);
				pstmtCommodity.executeUpdate();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				PrintWriter out = response.getWriter();
                out.print(e+"<br>");
                out.print("修改失败，返回"+"");
                out.print("<a href=/gouwuche/lyons.dao/GoodsDao?key=4>返回商品管理界面</a>");
                e.printStackTrace();
                return;
			}
            finally {
            	DbClose.close(pstmtCommodity, conn);
			}
            backNews(request, response, goods[1]);//参数三：商品名称
        }
        else if(key==2) {					//删除商品==========================
        	int id = 0;
        	id = Integer.parseInt(request.getParameter("id"));
    		String sql2 = "DELETE FROM commodity WHERE commodity_number="+id;
        	try {
				pstmtCommodity = conn.prepareStatement(sql2);
				pstmtCommodity.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				PrintWriter out = response.getWriter();
                out.print(e+"<br>");
                out.print("修改失败，返回"+"");
                out.print("<a href=/gouwuche/lyons.dao/GoodsDao?key=4>返回商品管理界面</a>");
                e.printStackTrace();
                e.printStackTrace();
                return;
			}
        	finally {
        		DbClose.close(pstmtCommodity, conn);
			}
        	backNews(request, response, request.getParameter("id"));//参数三：商品名称
        }else if(key==3) { 					//增添商品=================================
        	String name=request.getParameter("name");
        	String made=request.getParameter("made");
        	Double price=Double.parseDouble(request.getParameter("price"));
        	String pic=request.getParameter("pic");
        	int classify=Integer.parseInt(request.getParameter("type"));
        	int number=Integer.parseInt(request.getParameter("number"));
        	String sql2 = "INSERT INTO commodity "
        			+ "(commodity_name,commodity_made, commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES(?,?,?,?,?,?)";
        	try {
				pstmtCommodity = conn.prepareStatement(sql2);
				//name
				pstmtCommodity.setString(1,name); 
				//made
				pstmtCommodity.setString(2,made);
				//price
				pstmtCommodity.setDouble(3,price); 
				//num
				pstmtCommodity.setInt(4,number);
				//pic
				pstmtCommodity.setString(5,pic);
				//classify
				pstmtCommodity.setInt(6,classify);
				pstmtCommodity.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				PrintWriter out = response.getWriter();
                out.print(e+"<br>");
                out.print("添加商品失败，返回"+"");
                out.print("<a href=/gouwuche/lyons.dao/GoodsDao?key=4>返回商品管理界面</a>");
                e.printStackTrace();
                e.printStackTrace();
                return;
			}
        	finally {
        		DbClose.close(pstmtCommodity, conn);
			}
        	backNews(request, response, request.getParameter("name"));//参数三：商品名称
        }
                
            
     
    }
    
    
    /**
     * 
     * 返回用户消息
     * 修改商品成功后，返回提示操作信息
     * @param request
     * @param response
     * @param goodsName
     * @throws IOException
     */
    private void backNews(HttpServletRequest request, HttpServletResponse response, String goodsName) throws IOException
    {
        
        PrintWriter out = response.getWriter();
        out.print("<br><br><br>");
        out.print("<center><font size=5 color=red><B>"+goodsName+"</B></font>&nbsp;商品修改成功");
        out.print("<br><br><br>");
        out.print("<a href=/gouwuche/lyons.dao/GoodsDao?key=4>返回继续修改</a>");
        
    }

    public void init()
        throws ServletException{ }
    
}
