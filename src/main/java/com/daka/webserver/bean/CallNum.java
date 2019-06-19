package com.daka.webserver.bean;

/**
 * @description:
 * @author: zjt
 * @date: 2019-05-13 22:19
 */
public class CallNum {

    private int xzyg;
    private int dk;
    private int duser;
    private int euser;
    private int quser;
    private int qbd;
    private int re;

    public CallNum() {
        this.xzyg = 0;
        this.dk = 0;
        this.duser = 0;
        this.euser = 0;
        this.quser = 0;
        this.qbd = 0;
        this.re = 0;
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

}