<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="categoryModel" class="Model.CategoryModel"/>
<c:set var="categories" value="${categoryModel.categoryList}"/>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td class="art-menu">
            <ul>
                <c:forEach  var="category" items="${categories}"> 
                    <li><html:link page="/Layout.do?categoryID=${category.categoryID}">>>${category.categoryName}</html:link> </li>                   
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>

