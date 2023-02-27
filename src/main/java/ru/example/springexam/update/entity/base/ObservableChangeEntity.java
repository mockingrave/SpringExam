package ru.example.springexam.update.entity.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class ObservableChangeEntity extends BaseEntity implements Serializable {

    @Transient
    private ObservableChangeEntity sourceData;

    @PostLoad
    public void afterLoad() throws IOException, ClassNotFoundException {
        sourceData = cloneObject();
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Old Entity: {}", sourceData);
        log.info("New Entity: {}", this);
    }


    public ObservableChangeEntity cloneObject() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (ObservableChangeEntity) ois.readObject();
    }

}
