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
public class deleteNCategoryAction extends org.apache.struts.action.Action {

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
        deleteNCategoryActionForm myform = (deleteNCategoryActionForm) form;
        String[] categories = myform.getCategories();
        String IDs = "";
        CategoryModel categoryModel = new CategoryModel();
        for (int i = 0; i < categories.length; i++) {
            IDs = IDs + categories[i].toString() + ",";
        }
        IDs = IDs.substring(0, IDs.length() - 1);
        if (categoryModel.deletecategoryN(IDs) > 0) {
            return mapping.findForward("success");
        }
        //request.setAttribute("categories", IDs);
        return mapping.findForward("error");

    }
}