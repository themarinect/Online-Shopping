/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import Entities.Product;
import Model.ProductModel;
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
public class productActionNoForm extends org.apache.struts.action.Action {

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
        ProductModel productModel = new ProductModel();
        if (operation.equals("delete")) {
            int productID = Integer.parseInt(request.getParameter("productID").toString());
            if (productModel.deleteProduct(productID) > 0) {
                return mapping.findForward("success");
            }
            return mapping.findForward("error");
        } else if (operation.equals("deleteAll")) {
            String productIDs = request.getParameter("productIDs");
            request.setAttribute("productIDs", productIDs);
            if (productModel.deleteProductN(productIDs) > 0) {
                return mapping.findForward("success");
            }
        } else if (operation.equals("edit")) {
            int productID = Integer.parseInt(request.getParameter("productID").toString());
            Product product = productModel.getProduct(productID);
            request.setAttribute("productEdit", product);
            return mapping.findForward("edit");
        }
        return mapping.findForward("error");

    }
}