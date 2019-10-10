<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="1" width="100%">  
    <c:choose >
        <c:when test="${not empty userClient }">
            <tr>
                <td>Welcome ${userClient.userName}</td>
            </tr>
        </c:when>
        <c:otherwise>          
            <tr>
                <td>
                    <html:form action="/loginAction">
                        <table border="0" width="100%">
                            <tr>
                                <font color="red">${errorLogin}</font>
                            </tr>
                            <tr>
                                <td align="center">
                                User Name </td>
                            </tr>
                            <tr>
                                <td align="center">
                                <html:text property="userName"/></td>
                            </tr>
                            <tr>
                                <td align="center">
                                Password</td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <html:password property="password"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <html:submit value="Login"/>
                                    <html:reset />
                                </td>
                            </tr>
                        </table>
                    </html:form>
                </td>
            </tr>
        </c:otherwise>
    </c:choose>      
</table>

