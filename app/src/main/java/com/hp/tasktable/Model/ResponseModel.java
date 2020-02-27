package com.hp.tasktable.Model;

import java.util.List;

public class ResponseModel {
    private List<SuccessBean> Success;

    public List<SuccessBean> getSuccess() {
        return Success;
    }

    public void setSuccess(List<SuccessBean> Success) {
        this.Success = Success;
    }

    public static class SuccessBean {
        /**
         * id : 35
         * name : saurabh
         * category : Web development
         * categoryid : 1
         * address : testing
         * description : bhopal
         * contact : 659856325
         * empcode : AT0104
         * image : http://hradmin.aryupay.io/tracking/uploads/IMG_20190423_153014.jpg
         */

        private String id;
        private String name;
        private String category;
        private String categoryid;
        private String address;
        private String description;
        private String contact;
        private String empcode;
        private String image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getEmpcode() {
            return empcode;
        }

        public void setEmpcode(String empcode) {
            this.empcode = empcode;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
