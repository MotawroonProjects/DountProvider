package com.apps.dount_provider.model;

import java.io.Serializable;
import java.util.List;

public class OrderModel implements Serializable {
    private String id;
    private String user_id;
    private String representative_id;
    private String latitude;
    private String longitude;
    private String pay;
    private String status;
    private String address;
    private String sub_total;
    private String shipping;
    private String total;
    private String created_at;
    private String updated_at;
    private String canceled;
    private String day;
    private String time;
    private String dayName;
    private Setting setting;
    private User user;
    private List<Detail> details;


    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getRepresentative_id() {
        return representative_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPay() {
        return pay;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getSub_total() {
        return sub_total;
    }

    public String getShipping() {
        return shipping;
    }

    public String getTotal() {
        return total;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getCanceled() {
        return canceled;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getDayName() {
        return dayName;
    }

    public Setting getSetting() {
        return setting;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public User getUser() {
        return user;
    }

    public static class Setting implements Serializable {
        private String phone;
        private String gmail;
        private String whats;
        private String address;
        private String lat;
        private String longitude;

        public String getPhone() {
            return phone;
        }

        public String getGmail() {
            return gmail;
        }

        public String getWhats() {
            return whats;
        }

        public String getAddress() {
            return address;
        }

        public String getLat() {
            return lat;
        }

        public String getLongitude() {
            return longitude;
        }
    }

    public static class Product implements Serializable {
        private String id;
        private String photo;
        private String title;

        public String getId() {
            return id;
        }

        public String getPhoto() {
            return photo;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class Detail implements Serializable {
        private String id;
        private String order_id;
        private String product_id;
        private String qty;
        private String desc;
        private String product_price;
        private Product product;

        public String getId() {
            return id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public String getQty() {
            return qty;
        }

        public String getDesc() {
            return desc;
        }

        public String getProduct_price() {
            return product_price;
        }

        public Product getProduct() {
            return product;
        }
    }

    public static class User implements Serializable {
        private String id;
        private String first_name;
        private String last_name;
        private String photo;
        private String phone;
        private String code;
        private String purchase_gifts;
        private String register_by;
        private String share_gifts;
        private String total;
        private String created_at;
        private String updated_at;

        public String getId() {
            return id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getPhoto() {
            return photo;
        }

        public String getPhone() {
            return phone;
        }

        public String getCode() {
            return code;
        }

        public String getPurchase_gifts() {
            return purchase_gifts;
        }

        public String getRegister_by() {
            return register_by;
        }

        public String getShare_gifts() {
            return share_gifts;
        }

        public String getTotal() {
            return total;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }
    }
}
