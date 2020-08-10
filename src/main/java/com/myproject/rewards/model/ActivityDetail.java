package com.myproject.rewards.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class ActivityDetail {

    @Id
    @GeneratedValue
    private Integer id;
    private String activity;
    private String hours;
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    protected ActivityDetail(){

    }

    public ActivityDetail(Integer id, String activity, String hours, Date timestamp, Subscriber subscriber) {
        this.id = id;
        this.activity = activity;
        this.hours = hours;
        this.timestamp = timestamp;
        this.subscriber = subscriber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityDetail that = (ActivityDetail) o;
        return id.equals(that.id) &&
                Objects.equals(activity, that.activity) &&
                Objects.equals(hours, that.hours) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(subscriber, that.subscriber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activity, hours, timestamp, subscriber);
    }
}
