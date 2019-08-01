package ru.levin.tmspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedEntityGraph(
        name = "task-graph",
        attributeNodes = {
                @NamedAttributeNode("project")
        }
)
@Entity
@Table(name = "task")
public final class Task extends AbstractEntity implements Serializable {

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @Nullable
    private Project project;

    @Nullable
    @Column
    private Date startDate;

    @Nullable
    @Column
    private Date endDate;

    @Column
    @Enumerated(value = EnumType.STRING)
    @Nullable
    private Status status = Status.PLANNED;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

}
