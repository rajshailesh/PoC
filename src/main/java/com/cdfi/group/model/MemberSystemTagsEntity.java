
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
@Table(name = "member_systemTags")
public class MemberSystemTagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemTags_id", nullable = false)
    private BigInteger systemTags_id;
    @Column(name = "member_GUID", nullable = false)
    private String member_GUID;
    @Column(name = "system_tag_guid")
    private String system_tag_guid;
    @Column(name = "cbo_id")
    private BigInteger cbo_id;
    @Column(name = "member_code")
    private BigInteger member_code;
    @Column(name = "system_type", nullable = false)
    private Integer system_type;
    @Column(name = "system_id", nullable = false)
    private String system_id;
    @Column(name = "status")
    private Short status;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer is_edited;
    @Column(name = "is_active", nullable = false)
    private Boolean is_active;
    @Column(name = "last_uploaded_date")
    private LocalDateTime last_uploaded_date;
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime created_date;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updated_date;
    @Column(name = "updated_by")
    private String updated_by;
    @Column(name = "is_complete")
    private Integer is_complete;
}
