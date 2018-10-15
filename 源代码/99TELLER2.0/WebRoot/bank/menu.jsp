<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,org.zhoukan.dao.*,org.zhoukan.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>	
  <%MainMenuSP mainMenu = new MainMenuSP();
  List<MenuBean> list = mainMenu.getMenu("qq");
	for(int i = 0; i < list.size(); i++){
		String id = list.get(i).getPOWER_ID();
		String name = list.get(i).getPOWER_NAME();
		System.out.println(id+"  "+name);} %>
    <td width="182" valign="top"><div id="container">
    
      <!--  -->
      <% for(int i = 0; i < list.size(); i++){%>
      <h1 class="type"><a href="javascript:void(0)"><%= list.get(i).getPOWER_NAME()%></a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		<%
		ChildMenuSP child_menu = new ChildMenuSP();
		String id = list.get(i).getPOWER_ID();
		List<MenuBean> child_list = child_menu.getMenu("qq",id);
		for(int j = 0; j < child_list.size(); j++){ 
		%>
          <li><a href="" target="main"><%= child_list.get(j).getPOWER_NAME()%></a></li>
          <%} %>
          
        </ul>
      </div>
      <%} %>
      
     <!--  -->
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>

</body>
</html>