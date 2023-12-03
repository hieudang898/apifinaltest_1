package com.hocvien.finaltest.service.cservice.svmanager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonNoDate {
    public static Gson gson;

    public GsonNoDate() {
    }

    static {
        gson = new Gson();
    }
}
