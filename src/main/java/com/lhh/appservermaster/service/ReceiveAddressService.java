package com.lhh.appservermaster.service;

import com.lhh.appservermaster.domain.ReceiveAddress;

import java.util.List;

public interface ReceiveAddressService {

    /**
     *
     * @return 返回所有地址信息
     */
    List<ReceiveAddress> getAllReceiveAddresses();

    /**
     *
     * @param receiveId
     * @return 根据id返回地址信息
     */
    ReceiveAddress getReceiveAddressByID(Integer receiveId);

    /**
     *
     * @param receiveAddress
     * @return true 添加一条地址信息
     */
    boolean addReceiveAddress(ReceiveAddress receiveAddress);

    /**
     *
     * @param receiveAddress
     * @return true 更新一条地址信息
     */
    boolean updateReceiveAddressByID(ReceiveAddress receiveAddress);

    /**
     *
     * @param receiveId
     * @return true 删除一条地址信息
     */
    boolean deleteReceiveAddressByID(Integer receiveId);

}
