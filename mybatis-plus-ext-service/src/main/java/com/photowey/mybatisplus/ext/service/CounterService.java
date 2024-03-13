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
package com.photowey.mybatisplus.ext.service;

import com.photowey.mybatisplus.ext.processor.model.query.AbstractQuery;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * {@code CounterService}
 *
 * @author photowey
 * @date 2023/06/08
 * @since 1.0.0
 */
public interface CounterService<T> {

    default Long determineCounter(Supplier<Long> fx) {
        Long total = fx.get();

        return null == total ? 0L : total;
    }

    default Integer determineIntegerCounter(Supplier<Integer> fx) {
        Integer total = fx.get();

        return null == total ? 0 : total;
    }

    default BigDecimal determineBigDecimalCounter(Supplier<BigDecimal> fx) {
        BigDecimal total = fx.get();

        return null == total ? BigDecimal.ZERO : total;
    }

    default <Q extends AbstractQuery<T>> Long determineCounter(Q query, Function<Q, Long> fx) {
        Long total = fx.apply(query);

        return null == total ? 0L : total;
    }
}
