<%@ page import ="java.util.*"%>
<%@ page import ="com.pro.user.Shows"%>
<%@ page import ="com.pro.user.Hall"%>
<%@ page import ="com.pro.user.HallCapacity"%>


<table border=1>

<tr>
<th>Seat Type Id</th>
<th>Seat Type</th>
<!-- <th>Number Available Of Seats</th> -->
<th>Seat Fare</th>
<th>Book your Seat</th>

</tr>

<%



ArrayList<HallCapacity> mdata= (ArrayList<HallCapacity>) request.getAttribute("hallcaplist");


System.out.println("-----------------------------------------------------------------------"+request.getAttribute("hallid"));

Iterator<HallCapacity> it=mdata.iterator();
while(it.hasNext())
{
HallCapacity s=it.next();
System.out.println("----------------------------------------------------------------------"+s.getSeatTypeId());
if(String.valueOf(s.getHallId().getHallId()).equals(request.getParameter("hallid"))){
	//System.out.println(s.getMovieId().getMovieId() +" " +request.getParameter("movieid"));
	
	
%>
<tr>

<td> <%=s.getSeatTypeId().getSeatTypeId()%> </td>
<td> <%=s.getSeatTypeId().getSeatTypeDesc()%> </td>
<%-- <td> <%=s.getSeatCount()%> </td> --%>
<td> <%=s.getSeatTypeId().getSeatFare()%> </td>
<form action="/payment"> <td><input type = "text" name = "nos"></td>
<input type="hidden" value="<%=s.getSeatTypeId().getSeatFare()%>"  name="seatfare">
<input type="hidden" value="<%=s.getHallCapacityId()%>"  name="hallcapid">

<td><input type = "submit" value="Book"></td>
</form>

<%-- <td><%=s.getFromDate()%></td>
<td><%=s.getToDate()%></td> --%>

</tr>
<%
}
}

%>
</table>


