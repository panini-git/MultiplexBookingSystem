<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Enter Movie details</h2>
		<form action ="/entermovie" method="post">
			<!-- Enter Movie ID:"   "<input type="text" name="MovieId"><br/> -->
			Enter Movie name:" "<input type="text" name="MovieName" ><br/>
			<input type="submit" value="Enter" name="add">
			<!-- <input type="submit" value="Register" name="reg"> -->
		</form>
		
		<h2>Enter Hall details</h2>
		<form action ="/enterhall" method="post">
			<!-- Enter Movie ID:"   "<input type="text" name="id"><br/> -->
			
			Enter Hall Name :<input type="text" name="HallDesc" ><br/>
			Enter Seat capacity  :<input type="text" name="TotalCapacity" ><br/>
			
			<input type="submit" value="Enter" name="add">
			<!-- <input type="submit" value="Register" name="reg"> -->
		</form>
		
		
		<h2>Enter Shows details</h2>
		<form action ="/entershow" method="post">
		
			Enter Hall Id:<input type="text" name=HallId ><br/>
			Enter MovieId  :<input type="text" name="MovieId" ><br/>
			Enter Slot No  :<input type="text" name="SlotNo" ><br/>
			Enter From Date:<input type="text" name="FromDate" ><br/>
			Enter To Date  :<input type="text" name="ToDate" ><br/>
			<input type="submit" value="Enter" name="add">
		
		</form>
		
		
		<h2>Enter Seat Type Details</h2>
		<form action ="/addseattype" method="post">
			Enter SeatTypeId :<input type="text" name="SeatTypeId" ><br/>
			Enter Seat Descripton  :<input type="text" name="SeatTypeDesc" ><br/>
			Enter Seat SeatFare : <input type="text" name= "SeatFare">
			<input type="submit" value="Enter" name="add">
		</form>
		
		<h2>Enter Hall Capacity Details</h2>
		<form action ="/addhallcapacity" method="post">
			Enter HallCapacityId :<input type="text" name="HallCapacityId" ><br/>
			Enter Hall Id :<input type="text" name="hallId" ><br/>
			Enter SeatTypeId : <input type="text" name= "SeatTypeId">
			Enter SeatCount : <input type="text" name= "SeatCount">
			<input type="submit" value="Enter" name="add">
		</form>
		
	</body>
</html>