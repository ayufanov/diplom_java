package com.example.demo;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.apache.poi.ss.usermodel.Cell;

public class Vul {
    int id;
    String bdu_id, meas_num ,soft_version, sof_name, soft_type;
    private ComboBox status;
    public Vul(int id, String meas_num, String bdu_id, String sof_name, String soft_type, String soft_version, ComboBox status) {
        this.id = id;
        this.meas_num = String.valueOf(meas_num);
        this.bdu_id = bdu_id;
        this.sof_name = sof_name;
        this.soft_type = soft_type;
        this.soft_version = soft_version;
        this.status = status;
    }

    public Vul(int i, int i1, Cell cell, Cell cell1, Cell cell2, Cell cell3, ComboBox status) {
    }




    public int getId() {
        return id;
    }

    public String getNum() {
        return meas_num;
    }

    public String getBdu_id() {
        return bdu_id;
    }

    public String getSof_name() {
        return sof_name;
    }

    public String getSoft_type() {
        return soft_type;
    }

    public String getSoft_version() {
        return soft_version;
    }

    public String getMeas_num() {
        return meas_num;
    }

    public ComboBox getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMeas_num(int meas_num) {
        this.meas_num = String.valueOf(meas_num);
    }

    public void setSoft_version(int soft_version) {
        this.soft_version = String.valueOf(soft_version);
    }

    public void setBdu_id(String bdu_id) {
        this.bdu_id = bdu_id;
    }

    public void setSof_name(String sof_name) {
        this.sof_name = sof_name;
    }

    public void setSoft_type(String soft_type) {
        this.soft_type = soft_type;
    }

    public void setStatus(ComboBox status) {
        this.status = status;
    }
}
