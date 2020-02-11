package com.zenhomes.counter.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_at")
    @JsonIgnore
    private Instant lastModifiedAt = Instant.now();

}
