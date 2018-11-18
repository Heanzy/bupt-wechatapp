package com.lhh.appservermaster.service.Instance;


import com.lhh.appservermaster.dao.ReceiveAddressDao;
import com.lhh.appservermaster.domain.ReceiveAddress;
import com.lhh.appservermaster.service.ReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiveAddressServiceImp implements ReceiveAddressService {
    @Autowired
    private ReceiveAddressDao receiveAddressDao;

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
