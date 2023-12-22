package com.website.genie.dto;

import java.util.Date;

public abstract class BaseDTO {
    private Long id;

    private Date createDate;

    private String modifiedBy;

    private Date modifiedDate;

    public BaseDTO() {
    }

    public BaseDTO(Long id, Date createDate, String modifiedBy, Date modifiedDate) {
        this.id = id;
        this.createDate = createDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
