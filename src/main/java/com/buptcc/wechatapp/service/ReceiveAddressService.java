package com.buptcc.wechatapp.service;

import com.buptcc.wechatapp.domain.ReceiveAddress;

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

    /**
     *
     * @param receiveUserName
     * @return 根据收货人名字查询地址表
     */
    List<ReceiveAddress> getAddressesByReceiveUserName(String receiveUserName);

    /**
     *
     * @param userId
     * @return 根据用户id返回地址信息列表
     */
    List<ReceiveAddress> getAddressesByUserId(Integer userId);
}
