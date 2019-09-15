<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page language="java" session="true" %>
<%@ page import="controllers.ProductManager"%>
<%@page import="java.util.ArrayList,  java.util.Iterator;"%>




<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Titanium X CD Store</title>
<LINK href="assets/css/Styles.css" type="text/css" rel="stylesheet" />

</head>
<body>    
   	<jsp:include page="header.jsp" />
	<table style="width: 100%;">
		<tr>
		  <td colspan="2" valign="top"  align="center"><IMG src="assets/imgs/home_Flash.jpg" alt="image" width="762" height="252"></td>
	  </tr>
		<tr>
		  <td  height="100%" align="center"><table cellSpacing="5"
					cellPadding="0" width="874" border="0">
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
						<td width="55" height="100%" align="center"><table border="0">
								<tr>
									<td height="52" align="left" valign="middle"><img
										src="assets/imgs/music_category.jpg" width="146" height="12"></td>
								</tr>
								<!-- 								<tr> -->
								<!-- 									<td height="100%"> -->
								<%-- 									<a href="${pageContext.request.contextPath}/categoryList">Categories</a> --%>
								<!-- 									</td> -->
								<!-- 								</tr> -->
								<tr>
									<td><c:if test="${not empty categoryList}">
											<c:forEach items="${categoryList}" var="categoryInfo">
												<c:set var="categoryParts"
													value="${fn:split(categoryInfo,'|')}" />
												<c:set var="categoryName" value="${categoryParts[1]}" />
												<c:set var="categoryID" value="${categoryParts[0]}" />
												<a
													href="${pageContext.request.contextPath}/productList?categoryID=${categoryID}"><span>${categoryName}</span></a>
												<br />
											</c:forEach>
										</c:if></td>
								</tr>
								<tr>
									<td></td>
								</tr>
								<!-- %
							ProductManager cat = new ProductManager();

							ArrayList<String> result = null;
							StringBuilder sb = new StringBuilder("<html><body>");
							sb.append("<table border=0>" + "<tr></tr>");
							result = cat.getCategoryList();
							Iterator<String> it = result.iterator();
							while (it.hasNext()) {
								String category = it.next();
								//sb.append("<tr><td><a href="${pageContext.request.contextPath}/getPro">" + category + "</a></td></tr>");
							}
							sb.append("</table>");
							out.println(sb);
					% -->

							</table></td>
						<td><table cellSpacing="0" cellPadding="0" width="1"
								border="0">
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
						<td width="500">
						<table> <tr>
                        <td colspan="2"  class="Title">Your personal and shipping information :</td>
                    </tr><tr>
                        <td class="subMenu">First Name</td>
                        <td class="clientAreaLink"><label>${accountObj.firstName} </label></td>
                    </tr>
                    <tr>
                        <td class="subMenu">Last Name</td>
                        <td class="clientAreaLink"><label>${accountObj.lastName} </label></td>
                    </tr>
                    <tr>
                        <td class="subMenu">Email</td>
                        <td class="clientAreaLink"><label>${accountObj.email}</label></td>
                    </tr>
                    <tr>
                        <td class="subMenu">Phone</td>
                        <td class="clientAreaLink"><label>${accountObj.phone}</label></td>
                    </tr>
                   <tr>
                    <td class="subMenu">Street</td>
                        <td class="clientAreaLink"><label>${accountObj.addressObj.street}</label></td>
                    </tr>
                    <tr>
                        <td class="subMenu">City</td>
                        <td class="clientAreaLink"><label >${accountObj.addressObj.city} </label></td>
                    </tr>
                     <tr>
                        <td class="subMenu">Province</td>
                        <td class="clientAreaLink"><label>${accountObj.addressObj.province} </label></td>
                    </tr>
                    <tr>
                        <td class="subMenu">Country</td>
                         
                        	<td class="clientAreaLink"><label>${accountObj.addressObj.country} </label></td>
						 
                    </tr>
                   
                     <tr>
                        <td class="subMenu">Zip Code</td>
                        <td class="clientAreaLink"><label>${accountObj.addressObj.zipcode}</label></td>
                    <tr>
                        <td colspan="2" style="padding-right:30px; height:70px;vertical-align: middle; " align="right"> <a href="index.jsp"><input type="submit" class="btnAddtoCart" value="     Back     " /></a></td>
                       
                    </tr></table></td>
						<td><table cellSpacing="0" cellPadding="0"  
								border="0">
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
					</tr>
					<jsp:include page="footer.jsp" />
				</table></body>
</html>