package com.buptcc.wechatapp.service.Instance;


import com.buptcc.wechatapp.dao.ReceiveAddressDao;
import com.buptcc.wechatapp.domain.ReceiveAddress;
import com.buptcc.wechatapp.service.ReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiveAddressServiceImp implements ReceiveAddressService {

    @Autowired
    private ReceiveAddressDao receiveAddressDao;

    @Override
    public List<ReceiveAddress> getAddressesByUserId(Integer userId) {
        return receiveAddressDao.getAddressesByUserId(userId);
    }

    @Override
    public List<ReceiveAddress> getAddressesByReceiveUserName(String receiveUserName) {
        return receiveAddressDao.getAddressesByReceiveUserName(receiveUserName);
    }

    @Override
    public List<ReceiveAddress> getAllReceiveAddresses() {
        return receiveAddressDao.getAll();
    }

    @Override
    public ReceiveAddress getReceiveAddressByID(Integer receiveId) {
        return receiveAddressDao.getReceiveAddressByID(receiveId);
    }

    @Override
    public boolean addReceiveAddress(ReceiveAddress receiveAddress) {
        return receiveAddressDao.addReceiveAddress(receiveAddress);
    }

    @Override
    public boolean updateReceiveAddressByID(ReceiveAddress receiveAddress) {
        return receiveAddressDao.updateReceiveAddressByID(receiveAddress);
    }

    @Override
    public boolean deleteReceiveAddressByID(Integer receiveId) {
        return receiveAddressDao.deleteReceiveAddressByID(receiveId);
    }
}
