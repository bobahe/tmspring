package ru.levin.tmspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NamedEntityGraph(
        name = "task-graph",
        attributeNodes = {
                @NamedAttributeNode("project")
        }
)
@Entity
@Table(name = "task")
public final class Task extends AbstractEntity {

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @Nullable
    private Project project;

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

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

}
