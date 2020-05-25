package com.netcracker.ivanmerkush.fapi.models;

import java.sql.Date;
import java.util.Objects;

public class Complaint {
    private int idComplaint;
    private String adInfo;
    private Reason reason;
    private int idAccused;
    private Date fillingDate;
    private int idProsecutor;

    public Complaint() {
    }

    public Complaint(String adInfo, Reason reason, int idAccused, Date fillingDate, int idProsecutor) {
        this.adInfo = adInfo;
        this.reason = reason;
        this.idAccused = idAccused;
        this.fillingDate = fillingDate;
        this.idProsecutor = idProsecutor;
    }

    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    public String getAdInfo() {
        return adInfo;
    }

    public void setAdInfo(String adInfo) {
        this.adInfo = adInfo;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public int getIdAccused() {
        return idAccused;
    }

    public void setIdAccused(int idAccused) {
        this.idAccused = idAccused;
    }

    public Date getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(Date fillingDate) {
        this.fillingDate = fillingDate;
    }

    public int getIdProsecutor() {
        return idProsecutor;
    }

    public void setIdProsecutor(int idProsecutor) {
        this.idProsecutor = idProsecutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint that = (Complaint) o;
        return idComplaint == that.idComplaint &&
                idAccused == that.idAccused &&
                idProsecutor == that.idProsecutor &&
                Objects.equals(adInfo, that.adInfo) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(fillingDate, that.fillingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComplaint, adInfo, reason, idAccused, fillingDate, idProsecutor);
    }
}
