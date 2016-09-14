package com.ada.data.page;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ada.data.page.Filter.Operator;
import com.ada.data.page.Order.Direction;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Search {

	Operator operator() default Operator.eq;

	String name() default "";
}
