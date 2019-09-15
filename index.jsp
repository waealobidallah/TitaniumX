<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page language="java" session="true"%>
<%@ page import="controllers.ProductManager"%>
<%@page import="java.util.ArrayList,  java.util.Iterator;"%>


<html>
<head>
<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Titanium X CD Store</title>
<LINK href="assets/css/Styles.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="header.jsp" />
	<table style="width: 100%;">
		<tr>
			<td colspan="1" valign="top" align="center"><IMG
				src="assets/imgs/home_Flash.jpg" alt="image" width="762"
				height="252"></td>
		</tr>
		<tr>
			<td align="center"><table cellSpacing="5" cellPadding="0" width="874" 	border="0">
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
						<td  ><table width="500"
								class="ItemTable">
								<tr>
									
									<td height="52" colspan="3" align="left" valign="middle"><img
										src="assets/imgs/aboutusTitle.jpg" width="77" height="13"></td>
								</tr>
								<!-- tr>
		          <td><table class="ItemTable"  >
		            <tr>
		              <td  rowspan="4"><img src="assets/imgs/albums/1.gif" width="100" height="100"></td>
		              <td ><label class="ItemTitle">Title of the CD</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemPrice">Price :</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemStock">available in stock 4</label></td>
	                </tr>
	               <form action="addToCart" method="POST">
		            <tr>
		              <td><input name="AddToCart" type="submit" value="Add to cart"  class="btnAddtoCart" /></td>
	                </tr>
	               </form>
	              </table></td>
		          <td align="right"><table class="ItemTable">
		            <tr>
		              <td  rowspan="4"><img src="assets/imgs/albums/2.gif" alt="" width="100" height="100"></td>
		              <td ><label class="ItemTitle">Title of the CD</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemPrice">Price :</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemStock">available in stock 4</label></td>
	                </tr>
		            <tr>
		              <td><input name="AddToCart2" type="submit" value="Add to cart"  class="btnAddtoCart" /></td>
	                </tr>
	              </table></td>
	            </tr>
		        <tr>
		          <td height="30" colspan="2">&nbsp;</td>
	            </tr>
		        <tr>
		          <td><table class="ItemTable">
		            <tr>
		              <td  rowspan="4"><img src="assets/imgs/albums/3.gif" alt="" width="100" height="100"></td>
		              <td ><label class="ItemTitle">Title of the CD</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemPrice">Price :</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemStock">available in stock 4</label></td>
	                </tr>
		            <tr>
		              <td><input name="AddToCart4" type="submit" value="Add to cart"  class="btnAddtoCart" /></td>
	                </tr>
	              </table></td>
		          <td align="right"><table  class="ItemTable">
		            <tr>
		              <td  rowspan="4"><img src="assets/imgs/albums/4.gif" alt="" width="100" height="100"></td>
		              <td ><label class="ItemTitle">Title of the CD</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemPrice">Price :</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemStock">available in stock 4</label></td>
	                </tr>
		            <tr>
		              <td><input name="AddToCart5" type="submit" value="Add to cart"  class="btnAddtoCart" /></td>
	                </tr>
	              </table></td>
	            </tr>
		        <tr>
		          <td height="30" colspan="2">&nbsp;</td>
	            </tr>
		        <tr>
		          <td><table class="ItemTable">
		            <tr>
		              <td  rowspan="4"><img src="assets/imgs/albums/5.gif" alt="" width="100" height="100"></td>
		              <td ><label class="ItemTitle">Title of the CD</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemPrice">Price :</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemStock">available in stock 4</label></td>
	                </tr>
		            <tr>
		              <td><input name="AddToCart7" type="submit" value="Add to cart"  class="btnAddtoCart" /></td>
	                </tr>
	              </table></td>
		          <td align="right"><table  class="ItemTable">
		            <tr>
		              <td  rowspan="4"><img src="assets/imgs/albums/6.gif" alt="" width="100" height="100"></td>
		              <td ><label class="ItemTitle">Title of the CD</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemPrice">Price :</label></td>
	                </tr>
		            <tr>
		              <td><label class="ItemStock">available in stock 4</label></td>
	                </tr>
		            <tr>
		              <td><input name="AddToCart8" type="submit" value="Add to cart"  class="btnAddtoCart" /></td>
	                </tr>
	              </table></td>
	            </tr-->
								<tr>
									<td width="10"></td>
									<td class="aboutus">Established in 2014, Titanium X is a leading Internet retailer specializing in the sale of domestic and imported music CDs and Imports customers all over the world. We offer everyday low prices and a selection of product that is unmatched.

Titanium X has been honored for their exemplary customer service and satisfaction year after year receiving awards.

If this is your first time here, give us a try.</td>
									<td width="10"></td>
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
				</table></td>
			
		</tr>
		<tr>
			</body>
</html>