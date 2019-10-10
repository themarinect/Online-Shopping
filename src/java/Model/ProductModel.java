/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Product;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
//import java.lang.Integer;

/**
 *
 * @author admin
 */
public class ProductModel extends ConnectionDataBase {

    public ProductModel() {
    }

    public Iterator getProductList() {
        try {
            ArrayList ProductList = new ArrayList();
            makeConnection();
            ResultSet rs = getResultset("Select * From Products");
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setImgSrc(rs.getString("ImgSrc"));
                product.setStatus(rs.getBoolean("Status"));
                product.setSummary(rs.getString("summary"));
                ProductList.add(product);
            }
            releaseConnection();
            return ProductList.iterator();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Iterator getProductListByCategory(int categoryID) {
        try {
            ArrayList ProductList = new ArrayList();
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Products Where CategoryID=?");
            pst.setInt(1, categoryID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setImgSrc(rs.getString("ImgSrc"));
                product.setStatus(rs.getBoolean("Status"));
                product.setSummary(rs.getString("summary"));
                ProductList.add(product);
            }
            releaseConnection();
            return ProductList.iterator();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getPageCount(int pageSize) {
        try {
            int result = 0,  count = 0;
            makeConnection();
            ResultSet rs = getResultset("Select Count=Count(*) From Products");
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

    public Iterator getProductList(int page, int pageSize) {
        try {
            ArrayList ProductList = new ArrayList();
            makeConnection();
            CallableStatement cst = cn.prepareCall("{call spSeparationPage_Products(?,?)}");
            cst.setInt(1, page);
            cst.setInt(2, pageSize);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setStatus(rs.getBoolean("Status"));
                product.setSummary(rs.getString("summary"));
                product.setImgSrc(rs.getString("ImgSrc"));
                ProductList.add(product);
            }
            releaseConnection();
            return ProductList.iterator();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Product getProduct(int ProductID) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Products Where ProductID=?");
            pst.setInt(1, ProductID);
            ResultSet rs = pst.executeQuery();
            Product product = new Product();
            if (rs.next()) {
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setImgSrc(rs.getString("ImgSrc"));
                product.setStatus(rs.getBoolean("Status"));
                product.setSummary(rs.getString("summary"));
            }
            releaseConnection();
            return product;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean checkDupProductName(String ProductName) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Products Where ProductName=?");
            pst.setString(1, ProductName);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public int deleteProduct(int ProductID) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Delete Products Where ProductID=?");
            pst.setInt(1, ProductID);
            int result = pst.executeUpdate();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int deleteProductN(String ProductIDs) {
        try {
            makeConnection();
            String sql = "Delete Products Where ProductID in (" + ProductIDs + ")";
            Statement st = cn.createStatement();
            int result = st.executeUpdate(sql);
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int addProduct(String ProductName, float Price, String ImgSrc, String Summary, String Description, boolean status, int CategoryID) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID) Values(?,?,?,?,?,?,?)");
            pst.setString(1, ProductName);
            pst.setFloat(2, Price);
            pst.setString(3, ImgSrc);
            pst.setString(4, Summary);
            pst.setString(5, Description);
            pst.setBoolean(6, status);
            pst.setInt(7, CategoryID);
            int result = pst.executeUpdate();
            releaseConnection();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int updateProduct(String ProductName, float Price, String ImgSrc, String Summary, String Description, boolean status, int CategoryID, int ProductID) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Update Products Set ProductName=?,Price=?,ImgSrc=?,Summary=?,Description=?,Status=?,CategoryID=? Where ProductID=?");
            pst.setString(1, ProductName);
            pst.setFloat(2, Price);
            pst.setString(3, ImgSrc);
            pst.setString(4, Summary);
            pst.setString(5, Description);
            pst.setBoolean(6, status);
            pst.setInt(7, CategoryID);
            pst.setInt(8, ProductID);
            int result = pst.executeUpdate();
            releaseConnection();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
