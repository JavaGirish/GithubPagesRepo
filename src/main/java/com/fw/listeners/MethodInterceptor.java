package com.fw.listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<>();

        Map<String,String> map1 = new HashMap<>();
        map1.put("name","Test1");
        map1.put("count", "2");

        List<Map<String,String>> list = new ArrayList<>();
        list.add(map1);

        for(int i=0;i<methods.size();i++){
            for(int j=0; j<list.size();j++) {

                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))) {
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                    result.add(methods.get(i));
                }

            }
        }
        return result;
    }
}
