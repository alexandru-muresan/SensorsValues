<%@page import="main.java.com.springtutorial.jba.monitor.logic.CurrentValues"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AIDA64 Monitor</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
var xmlhttp;
// window.setInterval(myFunction(), 2000);
function loadXMLDoc(url,cfunc)
{
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=cfunc;
xmlhttp.open("GET",url,true);
xmlhttp.send();
}
function myFunction()
{
loadXMLDoc("./refreshValues",function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("valTable").innerHTML=xmlhttp.responseText;
    }
  });
}
</script>
</head>
<body>
	<button type="button" onclick="setInterval(function(){myFunction()},2000);">Begin AutoRefresh</button>
	AIDA64 Values:
	<br>
	<%-- <%TreeMap values = (TreeMap<String, Object>)request.getAttribute("values");%> --%>
	<%
	    TreeMap<String,Object> values = CurrentValues.AIDA_READS;
	%>
	<table id=valTable border="3px" >
	<tr>
		<th>Sensor</th>
		<th>Value</th> </tr>
		<c:forEach var="entry" items="${values}">
			<tr>
				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${entry.value}" /></td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>