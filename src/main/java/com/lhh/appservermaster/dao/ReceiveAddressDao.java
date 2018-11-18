package com.lhh.appservermaster.dao;

import com.lhh.appservermaster.domain.ReceiveAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiveAddressDao {

    /**
     *
     * @return 获取所有收获地址信息
     */
    List<ReceiveAddress> getAll();

    /**
     *
     * @param receiveId
     * @return 根据id返回地址信息
     */
    ReceiveAddress getReceiveAddressByID(@Param("receiveId") Integer receiveId);

    /**
     *
     * @param receiveAddress
     * @return true 成功添加一条地址信息
     */
    boolean addReceiveAddress(@Param("receiveAddress") ReceiveAddress receiveAddress);

    /**
     *
     * @param receiveAddress
     * @return true 成功id更新地址信息
     */
    boolean updateReceiveAddressByID(@Param("receiveAddress") ReceiveAddress receiveAddress);

    /**
     *
     * @param receiveId
     * @return true 删除一条地址信息
     */
    boolean deleteReceiveAddressByID(@Param("receiveId") Integer receiveId);

}
