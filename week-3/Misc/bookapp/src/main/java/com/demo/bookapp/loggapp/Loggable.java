package com.demo.bookapp.loggapp;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@Target(java.lang.annotation.ElementType.METHOD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Loggable {

}
