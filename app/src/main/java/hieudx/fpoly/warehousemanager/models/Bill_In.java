package hieudx.fpoly.warehousemanager.models;

public class Bill_In {
    private int id;
    private int total;
    private String date_time;
    private int id_user;

    public Bill_In(int id, int total, String date_time, int id_user) {
        this.id = id;
        this.total = total;
        this.date_time = date_time;
        this.id_user = id_user;
    }

    public Bill_In() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}