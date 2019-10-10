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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="stylesheet" href="../Style/Style.css" type="text/css" media="screen" />
        <title><tiles:getAsString name="title"/></title>
    </head>
    <body>
        <table border="1" width="780" align="center">
            <tbody>
                <tr>
                    <td colspan="2"><tiles:insert attribute="header"/></td>
                </tr>
                <tr>
                    <td width="180" valign="top">&nbsp;
                        <tiles:insert attribute="menu"/>
                    </td>
                    <td width="600" valign="top" bgcolor="#f1f1f1"><tiles:insert attribute="body"/></td>
                </tr>
                <tr>
                    <td colspan="2"><tiles:insert attribute="footer"/></td>
                </tr>
            </tbody>
        </table>        
    </body>
</html>
