/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Category;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author admin
 */
public class CategoryModel extends ConnectionDataBase {

    public CategoryModel() {
    }

    public Iterator getcategoryList() {
        try {
            ArrayList categoryList = new ArrayList();
            makeConnection();
            ResultSet rs = getResultset("Select * From Categories");
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                categoryList.add(category);
            }
            releaseConnection();
            return categoryList.iterator();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getPageCount(int pageSize) {
        try {
            int result = 0, count = 0;
            makeConnection();
            ResultSet rs = getResultset("Select Count=Count(*) From Categories");
            if (rs.next()) {
                count = rs.getInt("Count");
            }
            releaseConnection();
            int temp = count % pageSize;
            if (temp != 0) {
                result = count / pageSize + 1;
            } else {
                result = count / pageSize;
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public Iterator getcategoryList(int page, int pageSize) {
        try {
            ArrayList categoryList = new ArrayList();
            makeConnection();
            CallableStatement cst = cn.prepareCall("{call spSeparationPage_Categories(?,?)}");
            cst.setInt(1, page);
            cst.setInt(2, pageSize);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                categoryList.add(category);
            }
            releaseConnection();
            return categoryList.iterator();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Category getcategory(int CategoryID) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Categories Where CategoryID=?");
            pst.setInt(1, CategoryID);
            ResultSet rs = pst.executeQuery();
            Category category = new Category();
            if (rs.next()) {
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));

            }
            releaseConnection();
            return category;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean checkDupCategoryName(String CategoryName) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Categories Where CategoryName=?");
            pst.setString(1, CategoryName);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public int deletecategory(int CategoryID) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Delete Categories Where CategoryID=?");
            pst.setInt(1, CategoryID);
            int result = pst.executeUpdate();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    public int deletecategoryN(String CategoryIDs) {
        try {
            makeConnection();
            String sql = "Delete Categories Where CategoryID in (" + CategoryIDs + ")";
            Statement st = cn.createStatement();
            int result = st.executeUpdate(sql);
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int addcategory(String categoryName) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Insert Into Categories(CategoryName) Values(?)");
            pst.setString(1, categoryName);
            int result = pst.executeUpdate();
            releaseConnection();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int updatecategory(int categoryID, String categoryName) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Update  Categories Set CategoryName=? Where CategoryID=?");
            pst.setString(1, categoryName);
            pst.setInt(2, categoryID);
            int result = pst.executeUpdate();
            releaseConnection();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
