package com.littlemonkey.utils;

import com.littlemonkey.utils.http.HttpConnections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        List<Callable<String>> list = new ArrayList<Callable<String>>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(System.currentTimeMillis());
                    int cc = (int) Math.round(99999999 * Math.random());
                    String url = "http://localhost:8080/api/test/" + cc;
                    HttpConnections.createHttpConnection(null);
                    String content = HttpConnections.GET(url, null, null);
                    if (!content.equals(String.valueOf(cc))) {
                        throw new RuntimeException("?????????????????????????????????");
                    }
                    return null;
                }
            });
        }
        System.out.println("???");
        executorService.invokeAll(list);
    }
}
