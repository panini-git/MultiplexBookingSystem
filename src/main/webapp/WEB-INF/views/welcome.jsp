<%@ page import ="java.util.*"%>
<%@ page import ="com.pro.user.Movies"%>


<table border=1>

<tr><th>MovieId</td><td>Movie Name</td></tr>

<%
ArrayList<Movies> data= (ArrayList<Movies>) request.getAttribute("name");
Iterator<Movies> it=data.iterator();
while(it.hasNext())
{
	
Movies m=it.next();
int movievar = m.getMovieId();
 %>

<tr>
<%-- <td>  <a href="/showdetails" name="movieid" value="movievar">  <%=m.getMovieId()%></a></td> --%>

<td> <form action="/showdetails"> <input type = "submit" name ="movieid" value=<%=m.getMovieId()%>> </form>  </td>
<td><%=m.getMovieName()%></td>
</tr>
<%

}

%>
</table>


