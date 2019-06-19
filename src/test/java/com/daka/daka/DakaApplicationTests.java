package com.daka.daka;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class DakaApplicationTests {

    @Test
    public void contextLoads() {

        Map<String, String> map = new TreeMap<>();
        String tmp = "";

        map.put("secretid", "6a74c8d40fea4825a665aeaf0e1eed41");
        map.put("userId", "100");
        map.put("userName", "zhangsan");
        map.put("secretkey", "1e2305b00a4e47979ac9e131d793be268617775");

        for (String s : map.keySet()) {
            System.out.println("s = " + s);
            tmp += DigestUtils.md5Hex(map.get(s));
        }
        System.out.println("tmp = " + tmp);

    }

}
