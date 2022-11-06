/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

/**
 *
 * @author NgocHao
 */
public class UsersDTO {

    private String userID;
    private String fullName;
    private String password;
    private String roleId;
    private boolean status;

    public UsersDTO() {
    }

    public UsersDTO(String userID, String fullName, String password, String roleId, boolean status) {
        this.userID = userID;
        this.fullName = fullName;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
