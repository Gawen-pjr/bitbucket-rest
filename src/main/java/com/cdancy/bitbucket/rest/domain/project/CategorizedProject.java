/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cdancy.bitbucket.rest.domain.project;

import java.util.List;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.cdancy.bitbucket.rest.domain.common.Categorizable;
import com.cdancy.bitbucket.rest.domain.common.Category;
import com.cdancy.bitbucket.rest.utils.Utils;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CategorizedProject implements Categorizable {

    public abstract int id();

    @Nullable
    public abstract String key();

    @Nullable
    public abstract String name();

    CategorizedProject() {
    }

    @SerializedNames({ "projectId", "projectKey", "projectName", "categories" })
    public static CategorizedProject create(int id, String key, String name, List<Category> categories) {
        return new AutoValue_CategorizedProject(Utils.nullToEmpty(categories), id, key, name);
    }
}
