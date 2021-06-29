package com.laily.fp_mp.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Popular implements Serializable {
    private Integer id_job;
    private String job_title;
    private String company;
    private String location;
    private String deskripsi;
    private String salary;
    private String images;
    private String requirement;
    private String how_apply;
    private String about_company;

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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getHow_apply() {
        return how_apply;
    }

    public void setHow_apply(String how_apply) {
        this.how_apply = how_apply;
    }

    public String getAbout_company() {
        return about_company;
    }

    public void setAbout_company(String about_company) {
        this.about_company = about_company;
    }

    public Popular(Integer id_job, String job_title, String company, String location, String deskripsi, String salary, String images, String requirement, String how_apply, String about_company) {
        this.id_job = id_job;
        this.job_title = job_title;
        this.company = company;
        this.location = location;
        this.deskripsi = deskripsi;
        this.salary = salary;
        this.images = images;
        this.requirement = requirement;
        this.how_apply = how_apply;
        this.about_company = about_company;
    }
}
