
<%
	String username = request.getParameter("username");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	boolean alright = true;
%>
<jsp:useBean id="clientBean" class="es.uc3m.ctw.me_gustauto.controller.ClientBean" />
<jsp:setProperty name="clientBean" property="*" />
<form METHOD="POST" ACTION="?page=registration_form.jsp">
	<h2>Client registration</h2>
	<h4>
		<%
			if (username != null && username.length() == 0) {
				out.print("<div style='color:red;'>Username cannot be empty</div>");
				alright = false;
			}
		%>
		Username* <input name="username"
			value="<jsp:getProperty name="clientBean" property="username" />"><br>
		<%
			if (name != null && name.length() == 0) {
				out.print("<div style='color:red;'>Name cannot be empty</div>");
				alright = false;
			}
		%>
		Name* <input name="name"
			value="<jsp:getProperty name="clientBean" property="name" />"><br>
		<%
			if (email != null && email.length() == 0) {
				out.print("<div style='color:red;'>Email cannot be empty</div>");
				alright = false;
			}
		%>
		Email* <input name="email"
			value="<jsp:getProperty name="clientBean" property="email" />"><br>
		Address <input name="address"
			value="<jsp:getProperty name="clientBean" property="address" />"><br>
		Phone <input name="phone"
			value="<jsp:getProperty name="clientBean" property="phone" />"><br>
		<br>
		<%
			if (password1 != null && password2 != null) {
				if (!password1.equals(password2)) {
					out.print("<div style='color:red;'>Passwords must be equals</div>");
					alright = false;
				} else if (password1.length() < 6) {
					out.print("<div style='color:red;'>Password must contain of at least 6 characters</div>");
					alright = false;
				}
			} else {
				alright = false;
			}
		%>
		Password <input name="password1"
			value="<jsp:getProperty name="clientBean" property="password1"/>" type="password"><br>
		repeat <input name="password2" value="" type="password"><br>
		<br> <input type=submit value="Send" />
	</h4>
</form>
<%
	if (alright) {
		clientBean.storeClient();
		config.getServletContext().getRequestDispatcher("/index.jsp?page=thanks.jsp")
				.forward(request, response);
	}
%>
