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

import com.cakk.hibernate.pojo.context.ThreadContextHolder

class QueryContextHolder private constructor(
    threadContext: ThreadLocal<QueryContext> = ThreadLocal.withInitial(::QueryContext),
) : ThreadContextHolder<QueryContext, QueryContext.InvocationInfo>(threadContext) {

    override fun setContext(key: String, value: QueryContext.InvocationInfo) {
        getContext().save(key, value)
    }

    fun set(query: String, executionPoint: String) {
        getContext().save(query, executionPoint)
    }

    companion object {

        private lateinit var INSTANCE: QueryContextHolder

        @JvmStatic
        fun getInstance(): QueryContextHolder {
            return INSTANCE
        }

        @JvmStatic
        fun setContext(query: String, executionPoint: String) {
            INSTANCE.set(query, executionPoint)
        }

        @JvmStatic
        fun getContext(): QueryContext {
            return INSTANCE.getContext()
        }

        @JvmStatic
        fun clear() {
            INSTANCE.clearContext()
        }
    }
}
