package ru.levin.tmspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedEntityGraph(
        name = "project-graph",
        attributeNodes = {
                @NamedAttributeNode("tasks")
        }
)
@Entity
@Table(name = "project")
public final class Project extends AbstractEntity implements Serializable {

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
    private String description;

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

    @OneToMany(
            mappedBy = "project",
            cascade = {CascadeType.REMOVE}
    )
    @Nullable
    private List<Task> tasks;

    public Project() {
        this.id = UUID.randomUUID().toString();
    }

}