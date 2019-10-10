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
public class productDetailAction extends org.apache.struts.action.Action {

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
        ProductModel productModel = new ProductModel();
        String productID = request.getParameter("productID").trim();
        Product product = productModel.getProduct(Integer.parseInt(productID));
        request.setAttribute("productDetail", product);
        return mapping.findForward(SUCCESS);

    }
}