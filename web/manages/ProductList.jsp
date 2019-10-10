<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script language="javascript">
    function confirmDelete()
    {
        if(confirm("Do you want to Delete ?")==true)
        {
            return true;
        }
        return false;
    }
</script>
<jsp:useBean id="productModel" class="Model.ProductModel"/>
<c:set var="products" value="${productModel.productList}"/>
<html:form action="/manages/deleteNProductAction">
    <table width="100%" class="art-article"   border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="3" class="header">Product Management</td>
        </tr>    
        <tr>
            <td width="50%" align="left" colspan="2" >
            <html:link page="/Manages/AddProduct.do">Add product</html:link></td>
            <td width="50%" align="center">&nbsp;</td>
        </tr>
        <tr class="header1">
            <td width="20%" align="center">Product ID</td>
            <td width="50%" align="center">Product Name</td>
            <td width="30%" align="center">Manipulate</td>
        </tr>   
        <c:forEach var="product" items="${products}">  
            <tr>
                <td class="content" width="20%" align="center">${product.productID}</td>
                <td class="content" width="50%" align="left">${product.productName}</td>
                <td class="content" width="30%" align="center">  
                    <html:multibox value="${product.productID}" property="productIDs" />&nbsp;
                    <html:link action="/manages/productActionNoForm?operation=delete&productID=${product.productID}" onclick="return confirmDelete();" >Delete</html:link>&nbsp;||
                    &nbsp;<html:link action="/manages/productActionNoForm?operation=edit&productID=${product.productID}">Edit</html:link>
                </td>  
            </tr>
        </c:forEach>    
        <tr>
            <td colspan="3">
                <html:submit value="Delete All Checked" onclick="return confirmDelete();"/>                             
            </td>
        </tr>
    </table>
</html:form>
