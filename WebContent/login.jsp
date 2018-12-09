 <%@ taglib uri="/struts-tags" prefix="S" %>
<%@ include file="header.jsp" %>

<div align="center">
		<h2>Login Page</h2>
		<s:form action="doLogin">
			<s:textfield label="E-mail" name="email" />
			<s:password label="Password" name="password" />
			<s:submit value="Login" />
		</s:form>
	</div>
