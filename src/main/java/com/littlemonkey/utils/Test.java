package com.littlemonkey.utils;

import com.littlemonkey.utils.http.HttpConnections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            int cc = (int) Math.round(99999999 * Math.random());
            String url = "http://localhost:8080/api/test/" + cc;
            System.out.println(System.currentTimeMillis());
            System.out.println(url);
            System.out.println(i);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    HttpConnections.createHttpConnection(null);
                    String content = HttpConnections.GET(url, null, null);
                    if (!content.equals(String.valueOf(cc))) {
                        throw new RuntimeException("?????????????????????????????????");
                    }
                }
            });
        }
    }
}
