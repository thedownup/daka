package com.daka.webserver.model;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_controll
 * @author 
 */
public class SysControll implements Serializable {
    /**
     *  唯一标识
     */
    private String secretid;

    private String callNum;

    /**
     * (1 可以调用) （0 不可调用）
     */
    private Integer permission;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getSecretid() {
        return secretid;
    }

    public void setSecretid(String secretid) {
        this.secretid = secretid;
    }

    public String getCallNum() {
        return callNum;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysControll other = (SysControll) that;
        return (this.getSecretid() == null ? other.getSecretid() == null : this.getSecretid().equals(other.getSecretid()))
            && (this.getCallNum() == null ? other.getCallNum() == null : this.getCallNum().equals(other.getCallNum()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSecretid() == null) ? 0 : getSecretid().hashCode());
        result = prime * result + ((getCallNum() == null) ? 0 : getCallNum().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", secretid=").append(secretid);
        sb.append(", callNum=").append(callNum);
        sb.append(", permission=").append(permission);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}