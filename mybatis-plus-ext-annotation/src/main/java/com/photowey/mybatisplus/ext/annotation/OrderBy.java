/*
 * Copyright © 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photowey.mybatisplus.ext.annotation;

import com.photowey.mybatisplus.ext.enmus.ColumnNamingStrategy;
import com.photowey.mybatisplus.ext.enmus.OrderByEnum;
import com.photowey.mybatisplus.ext.enmus.OrderByMechanismEnum;

import java.lang.annotation.*;

/**
 * {@code OrderBy}
 * 排序(ORDER BY) 条件注解
 *
 * @author photowey
 * @date 2022/02/17
 * @since 1.0.0
 */
@Documented
@CriteriaQuery
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderBy {
    /**
     * 自定义的属性值
     *
     * @return
     */
    String alias() default "";

    /**
     * 排序
     * 说明: 由于解析器在解析注解的
     *
     * @return {@link OrderByEnum}
     */
    OrderByEnum orderBy() default OrderByEnum.ASC;

    /**
     * 默认下划线
     *
     * @return {@link ColumnNamingStrategy}
     */
    ColumnNamingStrategy naming() default ColumnNamingStrategy.LOWER_CASE_UNDER_LINE;

    /**
     * 排序字段的类型
     * STATIC: 静态排序 - 只要包含了 {@link OrderBy} 注解的字段均参与排序
     * DYNAMIC: 动态排序 - 包含了 {@link OrderBy} 注解的字段 且前端传了值的字段将参与排序
     *
     * @return {@link OrderByMechanismEnum}
     */
    OrderByMechanismEnum mechanism() default OrderByMechanismEnum.STATIC;
}
