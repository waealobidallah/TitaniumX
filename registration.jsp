<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page language="java" session="true"%>
<%@ page import="controllers.ProductManager"%>
<%@page import="java.util.ArrayList,  java.util.Iterator;"%>


<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="assets/js/registration.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Titanium X CD Store</title>
<LINK href="assets/css/Styles.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<form name="registration_form" id="register-form" onsubmit="return validateForm()" method="POST" action="register">
	<jsp:include page="header.jsp" />
	<table style="width: 100%;">
		<tr>
			<td colspan="2" valign="top" align="center"><IMG
				src="assets/imgs/home_Flash.jpg" alt="image" width="762"
				height="252"></td>
		</tr>
		<tr>
			<td style="position: relative; left: 50px;" width="55" height="100%"
				align="center"><table cellSpacing="5" cellPadding="0" width="874"
					border="0">
					<tr vAlign="top" align="left">
						<td align="center" width="55"><table cellSpacing="0"
								cellPadding="0" width="55" border="0">
								<tr>
									<td vAlign="middle" align="center" width="56" height="51"><table
											height="1" cellSpacing="0" cellPadding="0" width="13"
											bgColor="#bbbbbb" border="0">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td width="56"></td>
								</tr>
								<tr>
									<td vAlign="top" align="left" width="56" height="130">&nbsp;</td>
								</tr>
								<tr>
									<td vAlign="top" align="center" height="115"><table
											height="1" cellSpacing="0" cellPadding="0" width="13"
											bgColor="#bbbbbb" border="0">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td vAlign="middle" align="center" width="56" height="45"><table
											height="1" cellSpacing="0" cellPadding="0" width="13"
											bgColor="#bbbbbb" border="0">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td vAlign="top" align="left" width="56">&nbsp;</td>
								</tr>
							</table></td>
						
						<td><table height="100%" cellSpacing="0" cellPadding="0"
								width="1" border="0">
								<tr>
									<td vAlign="top" width="1" bgColor="#FFFFFF" height="52"></td>
								</tr>
								<tr>
									<td bgColor="#e2e2e2" height="400"></td>
								</tr>
								<tr>
									<td width="1" bgColor="#FFFFFF" height="52"></td>
								</tr>
							</table></td>
						<td ><TABLE cellSpacing="0" cellPadding="0" width="561" border="0">
		        <tr>
		          <td width="561" height="51"><img src="assets/imgs/registeration.jpg" alt="" width="125" height="13"></td>
	            </tr>
		        <tr>
		          <td width="561" vAlign="top" id="tdHome" runat="server"><table
												border="0" width="99%" cellpadding="5">
												 
													<tr>
														<td colspan="4" class="Title">Please fill your personal and
															shipping address</td>
													</tr>
												 
												<tbody class="sub_IconsTitle">
													<tr>
														<td>First Name</td>
														<td><input type="text" name="fname" value="" /></td>
														<td>Last Name</td>
														<td><input type="text" name="lname" value="" /></td>
													</tr>
													<tr>
														<td>Email</td>
														<td><input type="text" name="email" value="" /></td>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
													<tr>
														<td>Password</td>
														<td><input type="password" name="pass1" value="" /></td>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
													<tr>
														<td>Confirm Password</td>
														<td><input type="password" name="pass2" value="" /></td>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												<thead>

												</thead>
												<tbody class="sub_IconsTitle">
													<tr>
														<td>Street</td>
														<td><input type="text" name="street" value="" /></td>
														<td>City</td>
														<td><input type="text" name="city" value="" /></td>
													</tr>
													<tr>
														<td>Province</td>
														<td><input type="text" name="province" value="" /></td>
														<td>Country</td>
														<td><input type="text" name="country" value=" " /></td>
													<tr>
														<td>Zip Code</td>
														<td><input type="text" name="zipcode" value="" /></td>
														<td>Phone</td>
														<td><input type="text" name="phone" value="" /></td>
													</tr>
													<tr>
														<td colspan="4" style="height: 60px;" align="center">
															<input type="submit" value="Submit" />
														</td>
													</tr>
											</table></td>
		          </tr>
		        </TABLE></td>
						<td><table height="100%" cellSpacing="0" cellPadding="0"
								width="1" border="0">
								<tr>
									<td vAlign="top" width="1" bgColor="#FFFFFF" height="52"></td>
								</tr>
								<tr>
									<td bgColor="#e2e2e2" height="400"></td>
								</tr>
								<tr>
									<td width="1" bgColor="#FFFFFF" height="52"></td>
								</tr>
							</table></td>
						<td><jsp:include page="login.jsp" /></td>
						<td><table cellSpacing="0"
								cellPadding="0" width="55" border="0">
								<tr>
									<td vAlign="middle" align="center" width="56" height="51"><table
											height="1" cellSpacing="0" cellPadding="0" width="13"
											bgColor="#bbbbbb" border="0">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td width="56"></td>
								</tr>
								<tr>
									<td vAlign="top" align="left" width="56" height="130">&nbsp;</td>
								</tr>
								<tr>
									<td vAlign="top" align="center" height="115"><table
											height="1" cellSpacing="0" cellPadding="0" width="13"
											bgColor="#bbbbbb" border="0">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td vAlign="middle" align="center" width="56" height="45"><table
											height="1" cellSpacing="0" cellPadding="0" width="13"
											bgColor="#bbbbbb" border="0">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td vAlign="top" align="left" width="56">&nbsp;</td>
								</tr>
							</table></td>
					</tr>
					<jsp:include page="footer.jsp" />
				</table> </form></body>
</html>