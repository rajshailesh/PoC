/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.cdfi.group.domain;

import org.hibernate.validator.constraints.Length;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class AccessRight {
  @Length(min=1, max = 30)
  private String roleId;
  @Length(min=1, max = 3)
  private String categoryId;
  @Length(min=1, max = 30)
  private String functionalId;
  private List<Permission> rights;

  public AccessRight()
  {
    super();
  }

  public AccessRight(String roleId, String categoryId, String functionalId, final @Nonnull List<Permission> rights) {
    this.roleId = roleId;
    this.categoryId = categoryId;
    this.functionalId = functionalId;
    this.rights=rights;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getFunctionalId() {
    return functionalId;
  }

  public void setFunctionalId(String functionalId) {
    this.functionalId = functionalId;
  }

  public List<Permission> getRights() {
    return rights;
  }

  public void setRights(List<Permission> rights) {
    this.rights = rights;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccessRight that = (AccessRight) o;
    return Objects.equals(roleId, that.roleId) &&
            Objects.equals(categoryId, that.categoryId) &&
            Objects.equals(functionalId, that.functionalId) &&
            Objects.equals(rights, that.rights);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, categoryId, functionalId, rights);
  }

  @Override
  public String toString() {
    return "AccessRight{" +
            "roleId='" + roleId + '\'' +
            ", categoryId='" + categoryId + '\'' +
            ", functionalId='" + functionalId + '\'' +
            ", rights=" + rights +
            '}';
  }
}
