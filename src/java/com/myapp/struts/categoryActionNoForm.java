/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import Entities.Category;
import Model.CategoryModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author admin
 */
public class categoryActionNoForm extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

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

        String operation = request.getParameter("operation");
        CategoryModel categoryModel = new CategoryModel();
        if (operation.equals("delete")) {
            int categoryID = Integer.parseInt(request.getParameter("categoryID").toString());
            if (categoryModel.deletecategory(categoryID) > 0) {
                return mapping.findForward("success");
            }
            return mapping.findForward("error");
        } else if (operation.equals("edit")) {
            int categoryID = Integer.parseInt(request.getParameter("categoryID").toString());
            Category category = categoryModel.getcategory(categoryID);
            request.setAttribute("categoryEdit", category);
            return mapping.findForward("edit");
        }
        return mapping.findForward("error");

    }
}