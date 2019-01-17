package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.NoticeDao;
import com.buptcc.wechatapp.domain.Notice;
import com.buptcc.wechatapp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticeServiceImp implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> getAllNotices() {
        return noticeDao.getAll();
    }

    @Override
    public Notice getNoticeByID(Integer noticeId) {
        return noticeDao.getNoticeByID(noticeId);
    }

    @Override
    public boolean addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }

    @Override
    public boolean updateNoticeNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }

    @Override
    public boolean deleteNoticeByID(Integer noticeId) {
        return noticeDao.deleteNoticeByID(noticeId);
    }
}