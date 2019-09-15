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
						<td width="55" height="100%" align="center"><table
								 border="0">
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
						<td align="center"><table width="400" class="ItemTable">
								<tr>

								</tr>
								<tr>
									<td><c:if test="${servletMessage != ''}">
											<h3>${servletMessage}</h3>
										</c:if></td>
								</tr>
							</table>
							
								<c:if test="${not empty productList}">
									<table border="0"class="ItemTable" width="100%"  ><tr><td class="itemTableHeader">Item</td><td class="itemTableHeader">Title</td><td class="itemTableHeader">Price</td></tr>
									<c:forEach items="${productList}" var="productListElem">
										
										<c:set var="productListElemPart"
											value="${fn:split(productListElem,'|')}" />
										<c:set var="productID" value="${productListElemPart[0]}" />
										<c:set var="productName" value="${productListElemPart[1]}" />
										<c:set var="productPrice" value="${productListElemPart[2]}" />
										<c:set var="productImage" value="${productListElemPart[3]}" />
										<tr>
											<td><img src="${productImage}" height="50" /></td>
											<td><label class="ItemTitle"><a href="${pageContext.request.contextPath}/productInfo?productID=${productID}">${productName}</a>
											</label>
											</td>
										 
											<td><label class="ItemPrice">$${productPrice} CAD</label></td>
										</tr>
									</c:forEach>
									</table>
								</c:if>
						 
						<td width="1">

							<table height="100%" cellSpacing="0" cellPadding="0" width="1"
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
							</table>
						</td>
						<td><jsp:include page="login.jsp" /></td>
						<td><table cellSpacing="0" cellPadding="0" width="55"
								border="0">
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
					<tr>
						<td colspan="7" vAlign="middle" align="center" 
							></td>
					</tr>
					<tr>

					</tr>
				</table></td>
	        </tr><jsp:include page="footer.jsp" />
	      </table> 
</body>
</html>