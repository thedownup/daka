package com.daka.webserver.model;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_clock
 * @author 
 */
public class SysClock implements Serializable {
    /**
     * 员工唯一编号
     */
    private String userId;

    /**
     * 唯一标识
     */
    private String secretid;

    /**
     * 打卡时间
     */
    private Date clockTime;

    /**
     * 是否迟到 0 没有迟到 1 迟到
     */
    private Integer late;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSecretid() {
        return secretid;
    }

    public void setSecretid(String secretid) {
        this.secretid = secretid;
    }

    public Date getClockTime() {
        return clockTime;
    }

    public void setClockTime(Date clockTime) {
        this.clockTime = clockTime;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
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
        SysClock other = (SysClock) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSecretid() == null ? other.getSecretid() == null : this.getSecretid().equals(other.getSecretid()))
            && (this.getClockTime() == null ? other.getClockTime() == null : this.getClockTime().equals(other.getClockTime()))
            && (this.getLate() == null ? other.getLate() == null : this.getLate().equals(other.getLate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSecretid() == null) ? 0 : getSecretid().hashCode());
        result = prime * result + ((getClockTime() == null) ? 0 : getClockTime().hashCode());
        result = prime * result + ((getLate() == null) ? 0 : getLate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", secretid=").append(secretid);
        sb.append(", clockTime=").append(clockTime);
        sb.append(", late=").append(late);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}