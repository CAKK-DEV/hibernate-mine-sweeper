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

package com.cakk.hibernate.mine.exception

import com.cakk.hibernate.pojo.exception.BaseException

class DuplicateQueryException(
    point: String,
    query: String,
    count: Int,
    cause: Throwable? = null,
) : BaseException(
    message = "Duplicate Query found at $point. This query was executed $count times: $query",
    cause = cause,
)
