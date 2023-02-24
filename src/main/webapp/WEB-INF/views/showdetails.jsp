<%@ page import ="java.util.*"%>
<%@ page import ="com.pro.user.Shows"%>
<%-- <%@ page import = "org.springframework.web.servlet.ModelAndView"%> --%>


<table border=1>

<tr>
<th>ShowId</th>
<th>Movie Name</th>
<th>Hall Name</th>
<th>Timing</th>
</tr>

<%


ArrayList<Shows> sdata= (ArrayList<Shows>) request.getAttribute("shows");


Iterator<Shows> it=sdata.iterator();
while(it.hasNext())
{
Shows s=it.next();
	
if(String.valueOf(s.getMovieId().getMovieId()).equals(request.getParameter("movieid"))){
	System.out.println("eeeeeeess"+  s.getMovieId().getMovieName()+" "+ s.getMovieId().getMovieId() +" " +request.getParameter("movieid"));
%>
<tr>
<td> <%=s.getShowId()%></td>
<td> <form action="/moviedetails"> <input type = "submit" value = <%=s.getMovieId().getMovieName()%>  name ="movieid"> </form>  </td>
<td><%=s.getHallId().getHallDesc()%></td>
<td><%=s.getSlotNo()%></td>
<%
}
}
%>


