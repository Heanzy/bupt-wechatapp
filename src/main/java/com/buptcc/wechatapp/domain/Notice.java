package com.buptcc.wechatapp.domain;

import java.io.Serializable;

public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String noticeFile;
    private String publishDate;

    public Notice() {
    }

    public Notice(Integer noticeId, String noticeTitle, String noticeContent, String noticeFile, String publishDate) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeFile = noticeFile;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeFile='" + noticeFile + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public String getNoticeFile() {
        return noticeFile;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public void setNoticeFile(String noticeFile) {
        this.noticeFile = noticeFile;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
