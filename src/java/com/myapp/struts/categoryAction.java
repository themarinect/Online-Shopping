/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import Model.CategoryModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author admin
 */
public class categoryAction extends org.apache.struts.action.Action {

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        categoryActionForm myform = (categoryActionForm) form;
        String categoryName = myform.getCategoryName();
        CategoryModel categoryModel = new CategoryModel();
        String operation = request.getParameter("operation");
        if (operation.equals("add")) {
            if (categoryModel.addcategory(categoryName) > 0) {
                return mapping.findForward("success");
            }
        } else if (operation.equals("edit")) {
            int categoryID = myform.getCategoryID();
            if (categoryModel.updatecategory(categoryID, categoryName) > 0) {
                return mapping.findForward("success");
            }
        }
        return mapping.findForward("error");

    }
}