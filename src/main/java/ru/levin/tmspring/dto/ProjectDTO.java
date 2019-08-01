package ru.levin.tmspring.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.entity.Status;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "project")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectDTO extends AbstractDTO implements Serializable {

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
    private String description;

    @Column
    @Nullable
    private Date startDate;

    @Column
    @Nullable
    private Date endDate;

    @Column
    @Enumerated(value = EnumType.STRING)
    @Nullable
    private Status status = Status.PLANNED;

    public ProjectDTO() {
        this.id = UUID.randomUUID().toString();
    }

}
