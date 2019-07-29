package ru.levin.tmspring.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.entity.Status;
import ru.levin.tmspring.entity.Task;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "project")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProjectDTO extends AbstractDTO implements Serializable {

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
    private String description;

    @Column
    @Nullable
    private LocalDate startDate;

    @Column
    @Nullable
    private LocalDate endDate;

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

    public ProjectDTO() {
        this.id = UUID.randomUUID().toString();
    }
}
