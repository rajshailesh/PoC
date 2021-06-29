package com.cdfi.group.util;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utility {
    public static HashMap<String, List<String>> getListFromString(String key, @NotNull String body, String delimeter){
        String[] token = body.split(delimeter);
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> listVal = new ArrayList<>();
        for(String t: token) {
            if(t.contains(key)) {
                String[] arr = t.split("=");
                if(arr.length ==2 ) {
                    if(map.containsKey(arr[0])) {
                        map.get(arr[0]).add(arr[1].replace("'", ""));
                    }else {
                        listVal.add(arr[1].replace("'", ""));
                        map.put(arr[0], listVal);
                    }
                }
            }
        }
        return map;

    }
}
