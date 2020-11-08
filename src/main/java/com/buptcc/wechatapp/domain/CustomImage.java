package com.buptcc.wechatapp.domain;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class CustomImage implements Serializable {
    private Integer id;

    private String openId;

    private Integer productionType;

    private Integer imageType;

    private String imageName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getProductionType() {
        return productionType;
    }

    public void setProductionType(Integer productionType) {
        this.productionType = productionType;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
        CustomImage other = (CustomImage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getProductionType() == null ? other.getProductionType() == null : this.getProductionType().equals(other.getProductionType()))
            && (this.getImageType() == null ? other.getImageType() == null : this.getImageType().equals(other.getImageType()))
            && (this.getImageName() == null ? other.getImageName() == null : this.getImageName().equals(other.getImageName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getProductionType() == null) ? 0 : getProductionType().hashCode());
        result = prime * result + ((getImageType() == null) ? 0 : getImageType().hashCode());
        result = prime * result + ((getImageName() == null) ? 0 : getImageName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", productionType=").append(productionType);
        sb.append(", imageType=").append(imageType);
        sb.append(", imageName=").append(imageName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}