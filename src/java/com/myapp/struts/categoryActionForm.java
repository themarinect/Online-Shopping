/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import Model.ValidateData;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author admin
 */
public class categoryActionForm extends org.apache.struts.action.ActionForm {
    
  private int categoryID;
  private String categoryName;
   /**
    *
    */
   public categoryActionForm() {
       super();
       // TODO Auto-generated constructor stub
   }

   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       if (getCategoryName() == null || getCategoryName().length() < 1) {
           errors.add("categoryname", new ActionMessage("error.categoryname.required"));
           // TODO: add 'error.name.required' key to your resources
       }
       if(!ValidateData.isAZSpace(categoryName))
       {
           errors.add("categorynameFormat", new ActionMessage("error.categoryname.categorynameFormat"));
       }
       return errors;
   }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
