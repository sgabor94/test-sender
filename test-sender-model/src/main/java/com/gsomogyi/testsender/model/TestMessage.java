package com.gsomogyi.testsender.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class TestMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String source;

    private Date sendDate;

    @Override
    public String toString() {
        return "TestMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", sendDate=" + sendDate +
                '}';
    }
}