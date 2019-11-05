package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "mydb", catalog = "")
public class MessageEntity {
    private int idDirect;
    private String message;
    private Timestamp dateTime;
    private int idReceiver;
    private int idSender;

    @Id
    @Column(name = "id_direct")
    public int getIdDirect() {
        return idDirect;
    }

    public void setIdDirect(int idDirect) {
        this.idDirect = idDirect;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "date_time")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "id_receiver")
    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    @Basic
    @Column(name = "id_sender")
    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return idDirect == that.idDirect &&
                idReceiver == that.idReceiver &&
                idSender == that.idSender &&
                Objects.equals(message, that.message) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDirect, message, dateTime, idReceiver, idSender);
    }
}
