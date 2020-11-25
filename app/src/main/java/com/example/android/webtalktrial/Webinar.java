package com.example.android.webtalktrial;

import java.io.Serializable;
import java.net.URL;

class Webinar implements Serializable {
    private String webinarName;
    private String webinarHost;
    private String webinarTopic;
    private String webinarDate;
    private String webinarTime;
    private String webinarID;
    private String webinarInfo;
    private String addedBy;
    private String webinarStatus;
    private boolean webinarApproved;
    private int webinarViews;

    public Webinar()
    {

    }

    public Webinar(String webinarName, String webinarHost, String webinarTopic, String webinarDate, String webinarTime, String webinarID, String webinarInfo, String addedBy, String webinarStatus, boolean webinarApproved) {
        this.webinarName = webinarName;
        this.webinarHost = webinarHost;
        this.webinarTopic = webinarTopic;
        this.webinarDate = webinarDate;
        this.webinarTime = webinarTime;
        this.webinarID = webinarID;
        this.webinarInfo = webinarInfo;
        this.addedBy = addedBy;
        this.webinarStatus = webinarStatus;
        this.webinarApproved = webinarApproved;
        this.webinarViews = 0;
    }

    public String getWebinarName() {
        return webinarName;
    }

    public String getWebinarHost() {
        return webinarHost;
    }

    public String getWebinarTopic() {
        return webinarTopic;
    }

    public String getWebinarDate() {
        return webinarDate;
    }

    public String getWebinarTime() {
        return webinarTime;
    }

    public String getWebinarID() {
        return webinarID;
    }

    public String getWebinarInfo() {
        return webinarInfo;
    }

    public int getWebinarViews()
    {
        return webinarViews;
    }
    public String getAddedBy() {
        return addedBy;
    }

    public String getWebinarStatus() {
        return webinarStatus;
    }

    public boolean isWebinarApproved() {
        return webinarApproved;
    }
}
