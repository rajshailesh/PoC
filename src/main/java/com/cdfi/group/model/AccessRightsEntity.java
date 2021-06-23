package com.cdfi.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "access_rights")
public class AccessRightsEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "functional_id")
    private String functionalId;
    @Column(name = "rights")
    private String rights;
}
