package ru.levin.tmspring.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractDTO implements Serializable {

    @Id
    @Column(length = 191)
    @NotNull
    protected String id = UUID.randomUUID().toString();

}
