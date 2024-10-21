/*
 * Hibernate Mine Sweeper
 *
 * Copyright 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cakk.hibernate.mine.context

import com.cakk.hibernate.pojo.context.ThreadContext

class QueryContext : ThreadContext<QueryContext.InvocationInfo>() {

    override fun save(key: String, value: String) {
        data[key] = InvocationInfo(
            count = data[key]?.count?.plus(1) ?: 1,
            executionPoint = data[key]?.executionPoint?.plus(value) ?: listOf(value),
        )
    }

    data class InvocationInfo(
        val count: Int,
        val executionPoint: List<String>,
    )
}
