<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1" width="100%">
    <tr>
        <th> ID </th>                
        <th>Product Name</th>                
        <th>Price </th>                
        <th>Qua</th>   
        <th>Total</th> 
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="item" items="${cart.cartItems}">
        <tr>
            <td>${item.productID}</td>
            <td>${item.productName}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.quantity*item.price}</td>
            <td><html:link  action="/shoppingCartAction?action=Delete&productID=${item.productID}">Delete &nbsp;</html:link></td>
        </tr>
    </c:forEach>
    <tr>
        <tr>
            <td colspan="6" align="right">Total : ${cart.amount} </td> 
        </tr>
    </tr>
    <tr>
        <td colspan="6">
            <html:link  action="/shoppingCartAction?action=DeleteAll">Delete All&nbsp;</html:link>
            &nbsp;&nbsp; <html:link  action="/Layout.do">Continue</html:link>
            &nbsp;&nbsp; <html:link  action="/shoppingCartAction?action=Order">Order&nbsp;</html:link>
        </td>
    </tr>
</table>