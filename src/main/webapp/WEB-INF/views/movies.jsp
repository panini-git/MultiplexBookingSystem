<%@ page import ="java.util.*" %>
<%@ page import ="com.pro.user.Movies" %>


<table>

<tr><th>MovieId</td><td>Movie Name</td></tr>

<%


ArrayList<Movies> data= (ArrayList<Movies>) request.getAttribute("name");


Iterator<Movies> it=data.iterator();
while(it.hasNext())
{

Movies m=it.next();

%>

<tr>
<td><a href="/showdetails"> <%=m.getMovieId()%> </a></td>
<td><%=m.getMovieName()%></td>
</tr>
<%

}




%>


</table>


