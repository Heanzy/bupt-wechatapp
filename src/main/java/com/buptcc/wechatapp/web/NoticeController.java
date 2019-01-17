package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.Notice;
import com.buptcc.wechatapp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice/all")
    public List<Notice> getAllNotices(){
        return noticeService.getAllNotices();
    }

    @GetMapping("/notice")
    public Notice getNoticeByID(@RequestParam Integer noticeId){
        return noticeService.getNoticeByID(noticeId);
    }

    @PostMapping("/notice/add")
    public boolean addNotice(Notice notice){
        return noticeService.addNotice(notice);
    }

    @PostMapping("/notice/update")
    public boolean updateNoticeByID(Notice notice){
        return noticeService.updateNoticeNotice(notice);
    }

    @PostMapping("/notice/delete")
    public boolean deleteNoticeByID(@RequestParam  Integer noticeId){
        return noticeService.deleteNoticeByID(noticeId);
    }
}
