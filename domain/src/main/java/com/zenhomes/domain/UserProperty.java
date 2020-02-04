package com.zenhomes.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_property")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserProperty extends Auditing implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PropertyType type;
    
    @Column(name = "parent_id", columnDefinition = "int default 0")
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
