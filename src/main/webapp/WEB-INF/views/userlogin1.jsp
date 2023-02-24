<%@ page import ="java.util.*"%>
<%@ page import ="com.pro.user.Shows"%>
<%@ page import = "javax.servlet.http.Cookie" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<%

ArrayList<Shows> mdata= (ArrayList<Shows>) request.getAttribute("showlist");


Iterator<Shows> it=mdata.iterator();
while(it.hasNext())
{

Shows s=it.next();


if(s.getMovieId().getMovieName().equals(request.getAttribute("moviename")))  {
	System.out.println(s.getMovieId().getMovieId() +" " +request.getParameter("moviename"));
	/* Cookie c = new Cookie("k",s+"");

	response.addCookie(c); */
%>




<form action ="/userloginafter" method="post">
<h5> For booking movie <%=request.getAttribute("moviename")%> First login </h5>

Username:
<input type="text" name="username"><br/>
Password:
<input type="password" name="password" ><br/>
<input type="submit" value="Login" name="a1">
<input type="hidden" value=<%= s.getMovieId().getMovieName() %>  name ="moviename">
<input type="submit" value="Register" name="a1">
</form>
<%
}
}
%>
</body>
</html>