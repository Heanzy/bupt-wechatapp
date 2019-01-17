package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.ReceiveAddress;
import com.buptcc.wechatapp.service.ReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiveAddressController {
    @Autowired
    private ReceiveAddressService receiveAddressService;

    @GetMapping("receive-address/all")
    public List<ReceiveAddress> getAllReceiveAddresses(){
        return receiveAddressService.getAllReceiveAddresses();
    }

    @GetMapping("/receive-address")
    public ReceiveAddress getReceiveAddressByID(@RequestParam Integer receiveId){
        return receiveAddressService.getReceiveAddressByID(receiveId);

    }
    @PostMapping("receive-address/add")
    public boolean addReceiveAddress(ReceiveAddress receiveAddress){
        System.out.println(receiveAddress);
        return receiveAddressService.addReceiveAddress(receiveAddress);
    }

    @PostMapping("receive-address/update")
    public boolean updateReceiveAddressByID(ReceiveAddress receiveAddress){
        return receiveAddressService.updateReceiveAddressByID(receiveAddress);
    }

    @PostMapping("receive-address/delete")
    public boolean deleteReceiveAddressByID(@RequestParam Integer receiveId){
        return receiveAddressService.deleteReceiveAddressByID(receiveId);
    }

    @GetMapping("receive-address/receiveName")
    public List<ReceiveAddress> getAddressesByUserReceiveName(@RequestParam String receiveName){
        return receiveAddressService.getAddressesByReceiveUserName(receiveName);
    }

    @GetMapping("receive-address/userId")
    public List<ReceiveAddress> getAddressesByUserId(Integer userId){
        return receiveAddressService.getAddressesByUserId(userId);
    }
}
