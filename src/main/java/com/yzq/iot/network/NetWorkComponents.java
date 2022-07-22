package com.yzq.iot.network;

/**
 * @Author YuanZiQiang
 * @Description 网络组件
 * @Date 2022/7/22
 **/
public interface NetWorkComponents {

    /**
     * 初始化组件
     */
    void init();

    /**
     * 销毁组件
     */
    void shutdown();


    /**
     * 重置组件
     */
    void reload();

    /**
     * 获取网络组件类型
     *
     * @return NetWorkType
     * @see NetWorkType
     */
    NetWorkType getNetWorkType();
}
