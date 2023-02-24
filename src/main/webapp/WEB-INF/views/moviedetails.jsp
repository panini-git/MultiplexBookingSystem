<%@ page import ="java.util.*"%>
<%@ page import ="com.pro.user.Shows"%>
<%@ page import = "javax.servlet.http.Cookie" %>

<table border=1>

<tr>
<th>ShowId</th>
<th>Date</th>
<th>Timing</th>
<th>Available Seats</th>
<th>Book Seat</th>
</tr>

<%

ArrayList<Shows> mdata= (ArrayList<Shows>) request.getAttribute("movied");


Iterator<Shows> it=mdata.iterator();
while(it.hasNext())
{

Shows s=it.next();


if(s.getMovieId().getMovieName().equals(request.getAttribute("movieid")))  {
	System.out.println(s.getMovieId().getMovieId() +" " +request.getParameter("movieid"));
	/* Cookie c = new Cookie("k",s+"");

	response.addCookie(c); */
%>

<tr>
<td> <%=s.getShowId()%></td>
<td> <%=s.getFromDate()%></td>
<td><%=s.getSlotNo()%></td>
<td><%=s.getHallId().getTotalCapacity()%></td>

<td>
 <form action="/userlogin1"> 
<input type="hidden" value="<%= s.getMovieId().getMovieName() %>"  name ="moviename">
<input type = "submit"  value="Book"  > </form> 
 </td>
<!-- <td> <form action="/userlogin" > <input type = "submit" value="Book"></form></td> -->

<%-- <td><%=s.getFromDate()%></td>
<td><%=s.getToDate()%></td> --%>

</tr>
<%
}
}
%>
</table>


