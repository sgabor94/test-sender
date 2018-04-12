package com.gsomogyi.testsender.dto;

import java.io.Serializable;
import java.util.Date;

public class TestMessageDTO implements Serializable {

    private Long id;

    private String content;

    private String source;

    private Date sendDate;

    public TestMessageDTO() {
    }

    public TestMessageDTO(String content, String source, Date sendDate) {
        this.content = content;
        this.source = source;
        this.sendDate = sendDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
