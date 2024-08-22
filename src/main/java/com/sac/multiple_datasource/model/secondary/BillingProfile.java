package com.sac.multiple_datasource.model.secondary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * @author Sachith Rathnasiri
 */
@Entity
@Table(name = "BILLING_PROFILE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdOn", "updatedOn"}, allowGetters = true)
@DynamicUpdate
@Data
public class BillingProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADD_LINE_ONE")
    private String addressLineOne;

    @Column(name = "ADD_LINE_TWO")
    private String addressLineTwo;

    @Column(name = "ADD_LINE_THREE")
    private String addressLineThree;

    @Column(name = "USER_EMP_ID")
    private String userEmpId;

    @Column(nullable = false, updatable = false, name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(nullable = false, name = "UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "STATUS")
    private String status;
}
