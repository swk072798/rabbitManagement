package com.nwafu.databaseoprations.entity;

import java.io.Serializable;

public class RabbitHouse implements Serializable {
    private String rabbitHouseNo;

    private Double outdoorTemperature;

    private Double outdoorUmidity;

    private Double indoorTemperature;

    private Double indoorUmidity;

    private Double indoorWindSpeed;

    private Double ammonia;

    private Double hydrogenSulfide;

    private Double carbonMonoxideConcentration;

    private String fanOperation;

    private String wetCurtainOperation;

    private String lightingControl;

    private static final long serialVersionUID = 1L;

    public String getRabbitHouseNo() {
        return rabbitHouseNo;
    }

    public void setRabbitHouseNo(String rabbitHouseNo) {
        this.rabbitHouseNo = rabbitHouseNo == null ? null : rabbitHouseNo.trim();
    }

    public Double getOutdoorTemperature() {
        return outdoorTemperature;
    }

    public void setOutdoorTemperature(Double outdoorTemperature) {
        this.outdoorTemperature = outdoorTemperature;
    }

    public Double getOutdoorUmidity() {
        return outdoorUmidity;
    }

    public void setOutdoorUmidity(Double outdoorUmidity) {
        this.outdoorUmidity = outdoorUmidity;
    }

    public Double getIndoorTemperature() {
        return indoorTemperature;
    }

    public void setIndoorTemperature(Double indoorTemperature) {
        this.indoorTemperature = indoorTemperature;
    }

    public Double getIndoorUmidity() {
        return indoorUmidity;
    }

    public void setIndoorUmidity(Double indoorUmidity) {
        this.indoorUmidity = indoorUmidity;
    }

    public Double getIndoorWindSpeed() {
        return indoorWindSpeed;
    }

    public void setIndoorWindSpeed(Double indoorWindSpeed) {
        this.indoorWindSpeed = indoorWindSpeed;
    }

    public Double getAmmonia() {
        return ammonia;
    }

    public void setAmmonia(Double ammonia) {
        this.ammonia = ammonia;
    }

    public Double getHydrogenSulfide() {
        return hydrogenSulfide;
    }

    public void setHydrogenSulfide(Double hydrogenSulfide) {
        this.hydrogenSulfide = hydrogenSulfide;
    }

    public Double getCarbonMonoxideConcentration() {
        return carbonMonoxideConcentration;
    }

    public void setCarbonMonoxideConcentration(Double carbonMonoxideConcentration) {
        this.carbonMonoxideConcentration = carbonMonoxideConcentration;
    }

    public String getFanOperation() {
        return fanOperation;
    }

    public void setFanOperation(String fanOperation) {
        this.fanOperation = fanOperation == null ? null : fanOperation.trim();
    }

    public String getWetCurtainOperation() {
        return wetCurtainOperation;
    }

    public void setWetCurtainOperation(String wetCurtainOperation) {
        this.wetCurtainOperation = wetCurtainOperation == null ? null : wetCurtainOperation.trim();
    }

    public String getLightingControl() {
        return lightingControl;
    }

    public void setLightingControl(String lightingControl) {
        this.lightingControl = lightingControl == null ? null : lightingControl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rabbitHouseNo=").append(rabbitHouseNo);
        sb.append(", outdoorTemperature=").append(outdoorTemperature);
        sb.append(", outdoorUmidity=").append(outdoorUmidity);
        sb.append(", indoorTemperature=").append(indoorTemperature);
        sb.append(", indoorUmidity=").append(indoorUmidity);
        sb.append(", indoorWindSpeed=").append(indoorWindSpeed);
        sb.append(", ammonia=").append(ammonia);
        sb.append(", hydrogenSulfide=").append(hydrogenSulfide);
        sb.append(", carbonMonoxideConcentration=").append(carbonMonoxideConcentration);
        sb.append(", fanOperation=").append(fanOperation);
        sb.append(", wetCurtainOperation=").append(wetCurtainOperation);
        sb.append(", lightingControl=").append(lightingControl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}