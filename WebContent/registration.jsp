<%@ include file="header.jsp" %>
 <%@ taglib uri="/struts-tags" prefix="S" %>
 <STYLE type="text/css">  
.errorMessage{color:red;}  
</STYLE>  
<div align="center">
	<s:form action="register">
	<s:textfield name="name" label="Name:"></s:textfield>
		<s:password name="password" label="Password"></s:password>
		<s:textfield name="email" label="Email Id:"></s:textfield>
		<s:radio label="Gender" name="gender" list="#{'male':'Male','female':'Female'}" value="'male'"/>
		<s:textfield name="address1" label="Addres1:"></s:textfield>
		<s:textfield name="address2" label="Addresss2:"></s:textfield>
		<s:textfield name="city" label="City:"></s:textfield>
		<s:textfield name="state" label="State:"></s:textfield>
		<s:textfield name="zipcode" label="Zipcode:"></s:textfield>
		<s:textfield name="mobile" label="Mobile:"></s:textfield>
		 <s:submit value="Register" validate="true" ></s:submit>
	</s:form>
	</div>
	
</body>
</html>