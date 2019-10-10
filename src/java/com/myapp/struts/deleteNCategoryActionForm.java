/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author admin
 */
public class deleteNCategoryActionForm extends org.apache.struts.action.ActionForm {

    private String[] categories;
    

    public deleteNCategoryActionForm() {
        super();
    // TODO Auto-generated constructor stub
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//       if (getName() == null || getName().length() < 1) {
//           errors.add("name", new ActionMessage("error.name.required"));
//           // TODO: add 'error.name.required' key to your resources
//       }
        return null;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
