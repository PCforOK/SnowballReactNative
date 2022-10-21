package com.openkey.server.objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="rail")
public class Rail {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String railName;
    private boolean busy;

    private String lockType;
    @OneToOne
    private Phone Android;
    @OneToOne
    private Phone IPhone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRailName() {
        return railName;
    }

    public void setRailName(String railName) {
        this.railName = railName;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Phone getAndroid() {
        return Android;
    }

    public void setAndroid(Phone android) {
        Android = android;
    }

    public Phone getIPhone() {
        return IPhone;
    }

    public void setIPhone(Phone IPhone) {
        this.IPhone = IPhone;
    }
}
