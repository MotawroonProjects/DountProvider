package com.apps.dount_provider.model;

import java.io.Serializable;

public class UserModel extends StatusResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public static class Data implements Serializable {
        private String id;
        private String photo;
        private String name;
        private String password;
        private int is_active;
        private String phone;
        private String vehicle;
        private String identification;
        private String created_at;
        private String updated_at;
        private String api_token;
        private String vehicle_id;

        public void setApi_token(String api_token) {
            this.api_token = api_token;
        }

        private static String firebase_token;

        public String getId() {
            return id;
        }

        public String getPhoto() {
            return photo;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public int getIs_active() {
            return is_active;
        }

        public String getPhone() {
            return phone;
        }

        public String getVehicle() {
            return vehicle;
        }

        public String getIdentification() {
            return identification;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getApi_token() {
            return api_token;
        }

        public String getVehicle_id() {
            return vehicle_id;
        }

        public String getFirebase_token() {
            return firebase_token;
        }

        public void setFirebase_token(String firebase_token) {
            this.firebase_token = firebase_token;
        }
    }

}
