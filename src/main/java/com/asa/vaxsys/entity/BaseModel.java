package com.asa.vaxsys.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Base model.
 */
@MappedSuperclass
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Data
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * The Created at.
     */
    @Column(name = "created_at", nullable = false)
    protected Date createdAt;

    /**
     * The Updated at.
     */
    @Column(name = "updated_at", nullable = false)
    protected Date updatedAt;

    /**
     * On create.
     */
    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = new Date(System.currentTimeMillis());
    }

    /**
     * On update.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date(System.currentTimeMillis());
    }


}

