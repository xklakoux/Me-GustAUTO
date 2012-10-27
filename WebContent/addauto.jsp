<%@page import="java.util.Date"%>
<%@page import="es.uc3m.ctw.me_gustauto.MySQLConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<title>Add your auto advertisement</title>
</head>

<body>
	<jsp:useBean id="autoAdBean" class="es.uc3m.ctw.me_gustauto.AutoAdBean" scope="session" />
	<jsp:setProperty name="autoAdBean" property="*" />
	<form METHOD="POST" ACTION="add_auto_ad_form.jsp">
		<hr>
		<div align="center">
			<h2>Vehicle information</h2>
			<br> Please fill out the data<br> <br>

			Title <INPUT NAME="title" VALUE="<jsp:getProperty name="autoAdBean" property="title" />"><br> 
			Brand <INPUT NAME="brand" VALUE="<jsp:getProperty name="autoAdBean" property="brand" />"><br> 
			Model <INPUT NAME="model" VALUE="<jsp:getProperty name="autoAdBean" property="model" />"><br> 
			Engine <INPUT NAME="engine" VALUE="<jsp:getProperty name="autoAdBean" property="engine" />"><br>
			Registration number <INPUT NAME="registration_number" VALUE="<jsp:getProperty name="autoAdBean" property="registration_number" />"><br>
			Year of manufacture <input name="years" value="<jsp:getProperty name="autoAdBean" property="years" />"><br>
			Price <INPUT NAME="price" VALUE="<jsp:getProperty name="autoAdBean" property="price" />">$<br> 
			Mileage <INPUT NAME="mileage" VALUE="<jsp:getProperty name="autoAdBean" property="mileage" />">km<br> 
			Color <INPUT NAME="colour" VALUE="<jsp:getProperty name="autoAdBean" property="colour" />"><br> 
			<br>Description <br><TEXTAREA NAME="description" COLS=40 ROWS=6 ><jsp:getProperty name="autoAdBean" property="description" /></TEXTAREA><br>
			Username<INPUT readonly="readonly" NAME="username" VALUE="<%= session.getAttribute(MySQLConnector.USERNAME_OF_CLIENT) %>">
			<br>  
			Type 
				<INPUT TYPE="radio" <% if(autoAdBean.getAuto_moto().equals("auto")) out.print("checked"); %> name="auto_moto" value="auto"> Car
				<INPUT TYPE="radio" <% if(autoAdBean.getAuto_moto().equals("moto")) out.print("checked"); %> name="auto_moto" value="moto"> Motorbike <br>
			
			<!-- temporary, later might use a different way to input date -->
		    <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
		    <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
		    <script>
		    $(function() {
		        $( "#from" ).datepicker({
		            defaultDate: "+1w",
		            changeMonth: true,
		            changeYear:true,
		            dateFormat: 'yy-mm-dd',
		            minDate: 0,
		            onSelect: function( selectedDate ) {
		                $( "#to" ).datepicker( "option", "minDate", selectedDate);
		            }
		        });
		        $( "#to" ).datepicker({
		            defaultDate: "+1w",
		            changeMonth: true,
		            changeYear: true,
		            dateFormat: 'yy-mm-dd',
		            onSelect: function( selectedDate ) {
		                $( "#from" ).datepicker( "option", "maxDate", selectedDate);
		            }
		        });
		        
		        
		    });
		    </script>
		     
		    <label for="from">Ad valid from</label>
		    <input type="text" id="from" name="add_date" VALUE="<jsp:getProperty name="autoAdBean" property="add_date" />" />
		    <label for="to">to</label>
		    <input type="text" id="to" name="valid_to" VALUE="<jsp:getProperty name="autoAdBean" property="valid_to" />" />
			<br>		    
			<INPUT TYPE=Submit Value="Send">
			<%
				if (autoAdBean.storeAutoAd()) {
					out.print("<h1>AD SUCCESFULLY STORED</h1><br>");
					autoAdBean.reset();
				}
			%>
			<br><br><a href="index.jsp">Go back to index</a>
		</div>

		<br>
	</form>
</body>
</html>