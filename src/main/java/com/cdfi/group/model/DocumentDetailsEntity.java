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
@Table(name = "document_details")
public class DocumentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", nullable = false)
    private BigInteger documentId;
    @Column(name = "front_doc_original_name")
    private String frontDocOriginalName;
    @Column(name = "front_doc_modified_name")
    private String frontDocModifiedName;
    @Column(name = "rear_doc_original_name")
    private String rearDocOriginalName;
    @Column(name = "rear_doc_modified_name")
    private String rearDocModifiedName;
    @Column(name = "doc_path")
    private String docPath;
    @Column(name = "entry_source")
    private Short entrySource;
    @Column(name = "is_edited")
    private Integer isEdited;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private Integer uploadedBy;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;


}
