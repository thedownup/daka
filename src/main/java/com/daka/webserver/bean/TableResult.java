package com.daka.webserver.bean;

/**
 * @description:
 * @author: zjt
 * @date: 2019-05-14 21:42
 */
public class TableResult {

    private String name;
    private int xzyg;
    private int dk;
    private int duser;
    private int euser;
    private int quser;
    private int qbd;
    private String secretid;

    public String getSecretid() {
        return secretid;
    }

    public void setSecretid(String secretid) {
        this.secretid = secretid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXzyg() {
        return xzyg;
    }

    public void setXzyg(int xzyg) {
        this.xzyg = xzyg;
    }

    public int getDk() {
        return dk;
    }

    public void setDk(int dk) {
        this.dk = dk;
    }

    public int getDuser() {
        return duser;
    }

    public void setDuser(int duser) {
        this.duser = duser;
    }

    public int getEuser() {
        return euser;
    }

    public void setEuser(int euser) {
        this.euser = euser;
    }

    public int getQuser() {
        return quser;
    }

    public void setQuser(int quser) {
        this.quser = quser;
    }

    public int getQbd() {
        return qbd;
    }

    public void setQbd(int qbd) {
        this.qbd = qbd;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int re;
    private String status;

}