package com.lhh.appservermaster.service;


import com.lhh.appservermaster.domain.Notice;
import java.util.List;

public interface NoticeService {
    /**
     *
     * @return 所有通知信息
     */
    List<Notice> getAllNotices();

    /**
     *
     * @param noticeId
     * @return 根据id返回通知信息
     */
    Notice getNoticeByID(Integer noticeId);

    /**
     *
     * @param notice
     * @return true添加一条通知信息
     */
    boolean addNotice(Notice notice);

    /**
     *
     * @param notice
     * @return true 更新一条通知信息
     */
    boolean updateNoticeNotice(Notice notice);

    /**
     *
     * @param noticeId
     * @return true 删除一条通知信息
     */
    boolean deleteNoticeByID(Integer noticeId);
}
