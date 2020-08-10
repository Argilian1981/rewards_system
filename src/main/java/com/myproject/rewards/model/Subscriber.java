package com.myproject.rewards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String contact;
    @OneToMany(mappedBy = "subscriber")
    private List<ActivityDetail> activityDetails;

    protected Subscriber(){

    }

    public Subscriber(Integer id, String name, String address, String contact, List<ActivityDetail> activityDetails) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.activityDetails = activityDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<ActivityDetail> getActivityDetails() {
        return activityDetails;
    }

    public void setActivityDetails(List<ActivityDetail> activityDetails) {
        this.activityDetails = activityDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(activityDetails, that.activityDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, contact, activityDetails);
    }
}
