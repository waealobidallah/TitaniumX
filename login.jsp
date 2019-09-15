
	<%if (session.getAttribute("email") == null) {%>
	
				<form name="login-form" method="POST" action="login">
					<table>
					<tr>
					<td height="52" colspan="2"><IMG
					src="assets/imgs/login_Title.jpg" alt="" width="201" height="9"></td>
				</tr>
					<tr>
						<td width="72" height="30"><LABEL class="sub_IconsTitle">Email</LABEL></td>
						<td width="130"><input name="email" type="text" class="inputs" /></td>
					</tr>
					<tr>
						<td height="30"><LABEL class="sub_IconsTitle">Password&nbsp;&nbsp;</LABEL></td>
						<td><input name="password" type="password" class="inputs" /></td>
					</tr>
					<tr>
						<td height="25" colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td height="25" align="left" colspan="2"><input name="log in " type="submit" value="login"> or   <A class="linksmall" href="registration.jsp">
						Register </A> </td>
					</tr></table>
			</form>
		 
			<%} else {%>
			<form method="POST" action="logout">
				<table cellSpacing="0" cellPadding="0" width="200" border="0">
					<tr><td  height="52" align="center"><IMG src="assets/imgs/sub_clientsArea.jpg" alt="" width="135" height="9"></td></tr>
						<tr><td class="welcome"> Welcome to CD Store</td></tr>
						<tr>
							<td height="55"  >
								<table width="190"><tr><td><img src="assets/imgs/human.jpg" width="38" height="40"></td><td colspan="2" class="welcome">You are logged as: <b><%=session.getAttribute("email")%>
							</b></td></table>  
							</td>
						</tr>
						
						<tr>
							<td height="35" colspan="2"><input type="submit"
								value="Logout"></input> <a href="${pageContext.request.contextPath}/viewAccount" class="welcome">View Profile</a></td>
						</tr></table>
				</form>
						<%}%>


						
	 


