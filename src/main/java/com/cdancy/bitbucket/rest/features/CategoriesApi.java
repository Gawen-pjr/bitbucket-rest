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

package com.cdancy.bitbucket.rest.features;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;

import com.cdancy.bitbucket.rest.domain.project.ProjectCategories;
import com.cdancy.bitbucket.rest.domain.repository.RepositoryCategories;
import com.cdancy.bitbucket.rest.fallbacks.BitbucketFallbacks;
import com.cdancy.bitbucket.rest.filters.BitbucketAuthentication;

@Produces(MediaType.APPLICATION_JSON)
@RequestFilters(BitbucketAuthentication.class)
@Path("/rest/categories/1.0")
public interface CategoriesApi {

    @GET
    @Named("categories:project")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/project/{projectKey}")
    @Fallback(BitbucketFallbacks.ProjectCategoriesOnError.class)
    ProjectCategories projectCategories(@PathParam("projectKey") String projectKey);

    @GET
    @Named("categories:project")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/project/{projectKey}/repository/{repositorySlug}")
    @Fallback(BitbucketFallbacks.RepositoryCategoriesOnError.class)
    RepositoryCategories repositoryCategories(@PathParam("projectKey") String projectKey,
                                              @PathParam("repositorySlug") String repositorySlug);
}
