package com.hello.demo.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyPageHelper {

    int page() default 1;

    int pageSize() default 20;
}