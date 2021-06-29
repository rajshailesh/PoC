package com.cdfi.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permittable_groups")
public class PermittableGroupsEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "permittable_group_id")
    private String permittableGroupId;
    @Column(name = "permittables")
    private String permittables;

    public String getPermittableGroupId() {
        return permittableGroupId;
    }

    public void setPermittableGroupId(String permittableGroupId) {
        this.permittableGroupId = permittableGroupId;
    }

    public String getPermittables() {
        return permittables;
    }

    public void setPermittables(String permittables) {
        this.permittables = permittables;
    }
}
