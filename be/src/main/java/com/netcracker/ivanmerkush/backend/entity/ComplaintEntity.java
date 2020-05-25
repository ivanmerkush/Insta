package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "complaint", schema = "mydb", catalog = "")
public class ComplaintEntity {
    private int idComplaint;
    private String adInfo;
    private Reason reason;
    private int idAccused;
    private Date fillingDate;
    private int idProsecutor;

    @Id
    @Column(name = "id_complaint")
    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    @Basic
    @Column(name = "ad_info")
    public String getAdInfo() {
        return adInfo;
    }

    public void setAdInfo(String adInfo) {
        this.adInfo = adInfo;
    }

    @Basic
    @Column(name = "reason")
    @Enumerated(EnumType.STRING)
    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "id_accused")
    public int getIdAccused() {
        return idAccused;
    }

    public void setIdAccused(int idAccused) {
        this.idAccused = idAccused;
    }

    @Basic
    @Column(name = "filling_date")
    public Date getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(Date fillingDate) {
        this.fillingDate = fillingDate;
    }

    @Basic
    @Column(name = "id_prosecutor")
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
        ComplaintEntity that = (ComplaintEntity) o;
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
