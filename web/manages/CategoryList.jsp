<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="categoryModel" class="Model.CategoryModel"/>
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
<%
            int pageSize = 4;
            int count = categoryModel.getPageCount(pageSize);
            Object obj = request.getParameter("page");
            int p = 1;
            if (obj == null) {
                p = 1;
            } else {
                p = Integer.parseInt(obj.toString());
            }

%>
<c:set var="categories" value="<%= categoryModel.getcategoryList(p, pageSize) %>"/>
<html:form action="/manages/deleteNCategoryAction">
    <table width="100%" class="art-article"   border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="3" class="header">Category Management</td>
        </tr>    
        <tr>
            <td width="50%" align="left" colspan="2" >
            <html:link page="/Manages/AddCategory.do">Add Category</html:link></td>
            <td width="50%" align="center">&nbsp;</td>
        </tr>
        <tr class="header1">
            <td width="20%" align="center">Category ID</td>
            <td width="50%" align="center">Category Name</td>
            <td width="30%" align="center">Manipulate</td>
        </tr>   
        <c:forEach var="category" items="${categories}">  
            <tr>
                <td class="content" width="20%" align="center">${category.categoryID}</td>
                <td class="content" width="50%" align="left">${category.categoryName}</td>
                <td class="content" width="30%" align="center">  
                    <html:multibox value="${category.categoryID}" property="categories" />
                    <html:link action="/manages/categoryActionNoForm?operation=delete&categoryID=${category.categoryID}" onclick="return confirmDelete();" >Delete</html:link>&nbsp;||
                    &nbsp;<html:link action="/manages/categoryActionNoForm?operation=edit&categoryID=${category.categoryID}">Edit</html:link>
                </td>  
            </tr>
        </c:forEach>    
        <tr>
            <td colspan="3" align="center">
                <c:forEach var="p" begin="1" end="<%=count %>">
                    <html:link action="/Manages/CategoryList.do?page=${p}">
                    ${p}
                    </html:link>||&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <html:submit value="Delete All Checked" onclick="return confirmDelete();"/>                             
            </td>
        </tr>
    </table>
</html:form>
