package com.tinet.lize01;

/**
 * @author lize
 * @date 2022年04月17日 23:23
 */
public class Test {
    public static void main(String[] args) {
        String s = "{\"head\":[{\"name\":\"服务描述\",\"id\":\"540\"},{\"name\":\"取消服务原因\",\"id\":\"514\"}],\"data\":[[{\"id\":540,\"value\":\"备注\"},{\"id\":514,\"value\":\"备注1\"}],[{\"id\":540,\"value\":\"备注2\"},{\"id\":514,\"value\":\"备注24\"}]]}";

        System.out.println(s.startsWith("{"));
        System.out.println(s.endsWith("}"));
        System.out.println(s.contains("{\"head\":"));
        System.out.println(s.contains("\"data\":"));

    }


}
