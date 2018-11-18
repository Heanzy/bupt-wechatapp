package com.lhh.appservermaster.dao;

import com.lhh.appservermaster.domain.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoticeDao {

    List<Notice> getAll();

    Notice getNoticeByID(@Param("noticeId") Integer noticeId);

    boolean addNotice(@Param("notice") Notice notice);

    boolean updateNotice(@Param("notice") Notice notice);

    boolean deleteNoticeByID(@Param("noticeId") Integer noticeId);

}
