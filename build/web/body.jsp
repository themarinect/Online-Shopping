<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  import="java.util.Iterator" %>
<jsp:useBean id="productModel" class="Model.ProductModel"/>
<%
            String categoryID = request.getParameter("categoryID");
            Iterator products;
            if (categoryID == null) {
                products = productModel.getProductList();
            } else {
                int cateID = Integer.parseInt(categoryID);
                products = productModel.getProductListByCategory(cateID);
            }
%>
<table width="100%" border="1" cellpadding="0" cellspacing="0">  
    <c:set var="count" value="1"/>
    <c:forEach var="product" items="<%= products%>">
        <c:if test="${count mod 2==1}">             
            <tr>
            </c:if>
            <td width="200" height="150" valign="top" style="padding-left:8px" >
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td  height="25" valign="top">
                        ${product.productName}</td>
                    </tr>
                    <tr>
                        <td height="100" valign="top" style="padding-right:8px"  >
                            <img align="left"  src="Images/${product.imgSrc}" style="padding-right:8px"    />
                            <c:out value="${product.summary}"/>
                        </td>
                    </tr>
                    <tr>
                        <td height="25" valign="middle" align="right">
                            <html:link  action="/productDetailAction?productID=${product.productID}">Detail &nbsp;</html:link>
                            <html:link  action="/shoppingCartAction?action=Add&productID=${product.productID}">Add Cart &nbsp;</html:link>
                        </td>
                    </tr>                                               
            </table></td>
            <c:if test="${count mod 2==0}">             
            </tr>
        </c:if>
        <c:set var="count" value="${count+1}"/>
    </c:forEach>   
</table>