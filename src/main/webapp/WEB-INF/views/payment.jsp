<%@ page import ="java.util.*"%>
<%@ page import ="com.pro.user.Shows"%>
<%@ page import ="com.pro.user.Hall"%>
<%@ page import ="com.pro.user.HallCapacity"%>


<table>



<%



ArrayList<HallCapacity> mdata= (ArrayList<HallCapacity>) request.getAttribute("hallcaplist");

int nos = (int)request.getAttribute("nos");

System.out.println("-----------------------------------------------------------------------"+nos);

Iterator<HallCapacity> it=mdata.iterator();
while(it.hasNext())
{
HallCapacity s=it.next();
System.out.println("----------------------------------------------------------------------"+s.getSeatTypeId());
if(String.valueOf(s.getHallCapacityId()).equals(request.getParameter("hallcapid"))){
	//System.out.println(s.getMovieId().getMovieId() +" " +request.getParameter("movieid"));
%>





<tr>
<th>Amount to pay : <%=request.getAttribute("total")%> </th>
</tr>
<form action="/confirm" method="post"> <input type="hidden" value=<%=nos %>  name="nos"><input type="hidden" value="<%=s.getHallCapacityId()%>"  name="hallcapid">  
<input type="submit" value="Confirm"></form>
<form action="/cancel"> <input type="submit" value="Cancel"></form>

</table>
<% }
}
%>


