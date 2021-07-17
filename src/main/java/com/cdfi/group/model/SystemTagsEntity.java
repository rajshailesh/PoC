
package com.cdfi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_tags")
public class SystemTagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemtags_id", nullable = false)
    private BigInteger systemtags_id;
    @Column(name = "cbo_guid")
    private String cbo_guid;
    @Column(name = "system_tag_guid")
    private String system_tag_guid;
    @Column(name = "cbo_code")
    private BigInteger cbo_code;
    @Column(name = "system_type")
    private Short system_type;
    @Column(name = "system_id")
    private String system_id;
    @Column(name = "status")
    private Short status;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updated_by;
    @Column(name = "is_complete")
    private Integer is_complete;

}
