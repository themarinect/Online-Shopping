<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1" width="100%"  align="center">
    <tr>
        <td align="center">
            ${productDetail.productName}
        </td>
        
    </tr>
    <tr>      
        <td height="100" valign="top" style="padding-right:8px"  >
            <img align="left"  src="Images/${productDetail.imgSrc}" style="padding-right:8px"    />
            <c:out value="${productDetail.summary}"/>
        </td>
    </tr>
</table>
