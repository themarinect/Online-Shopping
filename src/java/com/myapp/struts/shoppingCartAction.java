/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import Model.ShoppingCartModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author admin
 */
public class shoppingCartAction extends org.apache.struts.action.Action {

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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ShoppingCartModel cart = (ShoppingCartModel) session.getAttribute("cart");
        if (action.equals("Add")) {
            String productID = request.getParameter("productID").trim();
            int intProductID = Integer.parseInt(productID);
            cart.addItem(intProductID, 1);
        } else if (action.equals("Delete")) {
            String productID = request.getParameter("productID").trim();
            int intProductID = Integer.parseInt(productID);
            cart.removeItem(intProductID);
        } else if (action.equals("DeleteAll")) {
            cart.removeAll();
        }
        return mapping.findForward(SUCCESS);

    }
}