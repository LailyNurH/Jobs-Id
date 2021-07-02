package com.laily.fp_mp.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Job implements Serializable {
    private Integer id_job;
    private String job_title;
    private String company;
    private String location;
    private String desc_job;
    private String salary;
    private String images;


    public Integer getId_job() {
        return id_job;
    }

    public void setId_job(Integer id_job) {
        this.id_job = id_job;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc_job() {
        return desc_job;
    }

    public void setDesc_job(String desc_job) {
        this.desc_job = desc_job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
