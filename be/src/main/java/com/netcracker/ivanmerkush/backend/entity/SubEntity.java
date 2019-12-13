package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sub", schema = "mydb", catalog = "")
public class SubEntity {
    private int idSub;
    private int idSubcriber;
    private int idHost;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub")
    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }

    @Basic
    @Column(name = "id_subcriber")
    public int getIdSubcriber() {
        return idSubcriber;
    }

    public void setIdSubcriber(int idSubcriber) {
        this.idSubcriber = idSubcriber;
    }

    @Basic
    @Column(name = "id_host")
    public int getIdHost() {
        return idHost;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubEntity subEntity = (SubEntity) o;
        return idSub == subEntity.idSub &&
                idSubcriber == subEntity.idSubcriber &&
                idHost == subEntity.idHost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSub, idSubcriber, idHost);
    }
}
