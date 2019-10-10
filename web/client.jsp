<%-- 
    Document   : layout
    Created on : Aug 24, 2010, 5:17:59 PM
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<jsp:useBean id="cart" class="Model.ShoppingCartModel" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="stylesheet" href="Style/Style.css" type="text/css" media="screen" />
        <title><tiles:getAsString name="title"/></title>
    </head>
    <body>
        <table border="1" width="780" align="center">
            <tbody>
                <tr>
                    <td colspan="3"><tiles:insert attribute="header"/></td>
                </tr>
                <tr>
                    <td width="180" valign="top">&nbsp;</td>
                    <td colspan="2"> <tiles:insert attribute="menubar"/></td>
                </tr>
                <tr>
                    <td width="180" valign="top">&nbsp;
                        <tiles:insert attribute="left"/>
                    </td>
                    <td width="400" valign="top" bgcolor="#f1f1f1"><tiles:insert attribute="body"/></td>
                    <td width="200" valign="top"><tiles:insert attribute="right"/></td>
                </tr>
                <tr>
                    <td colspan="3"><tiles:insert attribute="footer"/></td>
                </tr>
            </tbody>
        </table>        
    </body>
</html>
