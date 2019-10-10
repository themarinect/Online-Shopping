<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="categoryModel" class="Model.CategoryModel"/>
<c:set var="categories" value="${categoryModel.categoryList}"/>
<html:form action="/manages/productAction?operation=add" onsubmit="return validateProductActionForm(this);">
    <table width="100%" cellpadding="8">
        <tr>
            <td colspan="2" align="center">Manage Product</td>
        </tr>
        <tr>
            <td>
            <font color="red"><html:errors/></font></td>
        </tr>
        <tr>
            <td width="40%" align="right">Category </td>
            <td width="60%">
                <html:select property="categoryID">
                    <c:forEach  var="category" items="${categories}">                                         
                        <html:option   value="${category.categoryID}">
                        ${category.categoryName}
                        </html:option>
                    </c:forEach>
            </html:select></td>
        </tr>
        <tr>
            <td width="40%" align="right">Product Name</td>
            <td width="60%"><html:text property="productName"/></td>
        </tr>
        <tr>
            <td width="40%" align="right">Price</td>
            <td width="60%"><html:text property="price"/></td>
        </tr>
        <tr>
            <td width="40%" align="right">Image Source</td>
            <td width="60%"><html:text property="imgSrc"/></td>
        </tr>
        <tr>
            <td width="40%" align="right">Summury</td>
            <td width="60%"><html:text property="summary"/></td>
        </tr>
        <tr>
            <td width="40%" align="right">Description</td>
            <td width="60%"><html:text property="description"/></td>
        </tr>
        <tr>
            <td width="40%" align="right">Status</td>
            <td width="60%" ><html:radio  property="status" value="true"  />True
            <html:radio  property="status" value="false"/> False</td>
        </tr>
        <tr>
            <td align="center" colspan="2"><html:submit/><html:reset/></td>
        </tr>
    </table>
</html:form>
<html:javascript formName="productActionForm"/>
