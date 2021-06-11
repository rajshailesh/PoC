package com.cdfi.group.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
@Data
public class DocumentDetails {

    private BigInteger document_id;
    private String front_doc_original_name;
    private String front_doc_modified_name;
    private MultipartFile front_doc;
    private String rear_doc_original_name;
    private String rear_doc_modified_name;
    private MultipartFile rear_doc;
    private String doc_path;
    private Short status;
    private Short entry_source;
    private String last_uploaded_date;
    private Integer uploaded_by;
    private String created_date;
    private String created_by;
    private String updated_date;
    private String updated_by;

}
