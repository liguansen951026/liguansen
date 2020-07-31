package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "tb_device")
public class Device implements Serializable {
    @Id
    @Column(name = "deviceId")
    private Integer deviceid;

    @Column(name = "device_type_id")
    private Integer deviceTypeId;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_ram")
    private String deviceRam;

    private String color;

    private Double price;

    private String status;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;
	@Transient
	private Type type;
	
    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private static final long serialVersionUID = 1L;

    /**
     * @return deviceId
     */
    public Integer getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid
     */
    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * @return device_type_id
     */
    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    /**
     * @param deviceTypeId
     */
    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    /**
     * @return device_name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    /**
     * @return device_ram
     */
    public String getDeviceRam() {
        return deviceRam;
    }

    /**
     * @param deviceRam
     */
    public void setDeviceRam(String deviceRam) {
        this.deviceRam = deviceRam == null ? null : deviceRam.trim();
    }

    /**
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
	public String toString() {
		return "Device [deviceid=" + deviceid + ", deviceTypeId=" + deviceTypeId + ", deviceName=" + deviceName
				+ ", deviceRam=" + deviceRam + ", color=" + color + ", price=" + price + ", status=" + status
				+ ", createtime=" + createtime + ", type=" + type + "]";
	}
}