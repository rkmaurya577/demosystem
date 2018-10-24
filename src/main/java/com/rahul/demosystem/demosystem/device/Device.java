package com.rahul.demosystem.demosystem.device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deviceId;

    /** @NotNull is a Bean Validation annotation.It has nothing to do with database constraints
     * itself but Hibernate translate this into database constraints for us.
     *
     * But in future if we switch to other ORM then may be it not work that's why
     * for security reasons @Column(nullable = false) is also used.
     */

    @NotEmpty(message = "The description must not be empty")
    @Length(max = 500, message = "Description must be less than 500 characters.")
    @Column(nullable = false)
    private String description;


    @NotEmpty(message = "The status can't be empty")
    @Column(nullable = false)
    private String status;

    @Column(name = "operator_id")
    private int operatorId;

    @Column(name = "protocol_id")
    private int protocolId;


    /********************************* Constructor *********************************/
    public Device(){}

    public Device(String description, String status, int operatorId, int protocolId) {

        this.description = description;
        this.status = status;
        this.operatorId = operatorId;
        this.protocolId = protocolId;
    }


    /***************************** Getters & Setters *****************************/

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", operatorId=" + operatorId +
                ", protocolId=" + protocolId +
                '}';
    }
}