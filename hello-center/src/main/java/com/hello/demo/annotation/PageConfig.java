package com.hello.demo.annotation;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.demo.entity.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;

@Aspect
@Component
public class PageConfig {

    @Around("@annotation(com.hello.demo.annotation.MyPageHelper)")
    public Result around(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = getMethod(joinPoint);
        MyPageHelper annotation = method.getAnnotation(MyPageHelper.class);
        int page = annotation.page();
        int pageSize = annotation.pageSize();

        //获取参数分页
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameters.length; i++) {
            String parameterName = parameters[i].getName();
            if ("page".equals(parameterName)){
                page = (Integer) args[i];
            }else if ("page_size".equals(parameterName)){
                pageSize = (Integer) args[i];
            }else if ("jsonObject".equals(parameterName)) {
                if (args[i] instanceof JSONObject) {
                    page = ((JSONObject) args[i]).getInteger("page");
                    pageSize = ((JSONObject) args[i]).getInteger("page_size");
                }
            }
        }
        PageHelper.startPage(page, pageSize);
        HashMap<Object, Object> hashMap = new HashMap<>(16);
        //执行目标方法
        Result result = (Result) joinPoint.proceed();
        Object data = result.getData();
        if (data instanceof List) {
            PageInfo pageInfo = new PageInfo<>((List) data);
            hashMap.put("totalCount", pageInfo.getTotal());
            hashMap.put("totalPageCount", pageInfo.getPages());
            hashMap.put("info", data);
            return Result.success(hashMap);
        }
        return result;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new RuntimeException("注解只能用户方法！");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        return joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }


}
