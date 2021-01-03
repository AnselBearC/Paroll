package com.ansel.payroll.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class PyOrderForm implements Serializable {
    private Integer id;

    private String company;

    @ApiModelProperty(value = "款号")
    private String styleNumber;

    @ApiModelProperty(value = "款式名称")
    private String styleDescription;

    @ApiModelProperty(value = "裁单数量")
    private Integer cuttingNumber;

    @ApiModelProperty(value = "实际数量")
    private Integer actualNumber;

    @ApiModelProperty(value = "是否完成?1：完成0：未完成")
    private Integer isComplete;

    private String startDate;

    private String endingDate;

    private String note;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public Integer getCuttingNumber() {
        return cuttingNumber;
    }

    public void setCuttingNumber(Integer cuttingNumber) {
        this.cuttingNumber = cuttingNumber;
    }

    public Integer getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", company=").append(company);
        sb.append(", styleNumber=").append(styleNumber);
        sb.append(", styleDescription=").append(styleDescription);
        sb.append(", cuttingNumber=").append(cuttingNumber);
        sb.append(", actualNumber=").append(actualNumber);
        sb.append(", isComplete=").append(isComplete);
        sb.append(", startDate=").append(startDate);
        sb.append(", endingDate=").append(endingDate);
        sb.append(", note=").append(note);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}