/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import Model.ProductModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author admin
 */
public class productAction extends org.apache.struts.action.Action {

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
        DynaActionForm myform = (DynaActionForm) form;
        String productName = (String) myform.get("productName");
        float price = Float.parseFloat(myform.get("price").toString());
        String imgSrc = (String) myform.get("imgSrc");
        String summary = (String) myform.get("summary");
        String description = (String) myform.get("description");
        int categoryID = Integer.parseInt(myform.get("categoryID").toString());
        ProductModel productModel = new ProductModel();
        boolean status = Boolean.parseBoolean(myform.get("status").toString());
        String operation = request.getParameter("operation");
        if (operation.equals("add")) {
            if (productModel.addProduct(productName, price, imgSrc, summary, description, status, categoryID) > 0) {
                return mapping.findForward("success");
            }
        } else if (operation.equals("edit")) {
            int productID = Integer.parseInt(myform.get("productID").toString());
            if (productModel.updateProduct(productName, price, imgSrc, summary, description, status, categoryID, productID) > 0) {
                return mapping.findForward("success");
            }
        }
        //request.setAttribute("productName", myform.get("productName"));
        return mapping.findForward("error");

    }
}