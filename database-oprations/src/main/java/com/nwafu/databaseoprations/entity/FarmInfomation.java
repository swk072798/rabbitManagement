package com.nwafu.databaseoprations.entity;

import java.io.Serializable;

public class FarmInfomation implements Serializable {
    private String farmUuid;

    private String farmName;

    private String owner;

    private String farmAddress;

    private static final long serialVersionUID = 1L;

    public String getFarmUuid() {
        return farmUuid;
    }

    public void setFarmUuid(String farmUuid) {
        this.farmUuid = farmUuid == null ? null : farmUuid.trim();
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName == null ? null : farmName.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getFarmAddress() {
        return farmAddress;
    }

    public void setFarmAddress(String farmAddress) {
        this.farmAddress = farmAddress == null ? null : farmAddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", farmUuid=").append(farmUuid);
        sb.append(", farmName=").append(farmName);
        sb.append(", owner=").append(owner);
        sb.append(", farmAddress=").append(farmAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}