<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<html:form action="/manages/categoryAction?operation=add">
    <table width="100%" cellpadding="8">
        <tr>
            <td colspan="2" align="center">Manage Category</td>
        </tr>
        <tr>
            <td>
            <font color="red"><html:errors/></font></td>
        </tr>
        <tr>
            <td width="40%">Category Name</td>
            <td width="60%"><html:text property="categoryName"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><html:submit/><html:reset/></td>
        </tr>
    </table>
</html:form>
