package com.sunshinevvv.thinkinginjava.containers;

import com.sunshinevvv.thinkinginjava.common.BasicModel;

import java.util.*;

/**
 * Created by 光 on 2017/2/11.
 */
public class InterfaceVsIterator {
    public static void display(Iterator<BasicModel> itr) {
        while (itr.hasNext()) {
            BasicModel model = itr.next();
            System.out.println(model + " ");
        }
        System.out.println();
    }

    public static void display(Collection<BasicModel> models) {
        for (BasicModel model : models) {
            System.out.println(model + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<BasicModel> modelList = BasicModel.createModel(8);
        Set<BasicModel> modelSet = new HashSet<>(modelList);
        Map<String, BasicModel> modelMap = new LinkedHashMap<>();
        for (int i = 0; i < modelList.size(); i++) {
            modelMap.put(modelList.get(i).getName(), modelList.get(i));
        }

        display(modelList);
        display(modelSet);
        display(modelList.iterator());
        display(modelSet.iterator());

        System.out.println(modelMap);
        System.out.println(modelMap.keySet());
        display(modelMap.values());
        display(modelMap.values().iterator());
    }
}
