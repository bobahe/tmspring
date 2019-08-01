package ru.levin.tmspring.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
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
@Table(name = "task")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskDTO extends AbstractDTO implements Serializable {

    @Nullable
    @Column
    private String name;

    @Nullable
    @Column
    private String description;

    @Nullable
    @Column
    private Date startDate;

    @Nullable
    @Column
    private Date endDate;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column
    private Status status = Status.PLANNED;

    @Nullable
    @Column(name = "project_id")
    private String projectId;

    public TaskDTO() {
        this.id = UUID.randomUUID().toString();
    }

}
