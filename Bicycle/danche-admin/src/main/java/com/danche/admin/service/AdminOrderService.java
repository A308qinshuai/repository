package com.danche.admin.service;


import com.danche.pojogongju.EUDataGridResult;

/**
 * Created by liuzhen on 2018/3/14.
 */
public interface AdminOrderService {
    EUDataGridResult getItemList(int page);
    EUDataGridResult getOutList(int page);
    EUDataGridResult getBikeList(int page);
    EUDataGridResult getUserList(int page);
    EUDataGridResult getRequestList(int page);

}
