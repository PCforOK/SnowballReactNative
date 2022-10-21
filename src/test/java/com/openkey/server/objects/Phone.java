package com.openkey.server.objects;

import javax.persistence.*;

@Entity
@Table
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String device_name;
    private String os;

    private String os_version;
    private String ip;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os =os;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }
}
