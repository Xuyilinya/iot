package com.yzq.iot.network;

/**
 * @Author YuanZiQiang
 * @Description //TODO
 * @Date 2022/7/22
 **/
public abstract class DefaultNetWorkComponents implements NetWorkComponents{

    public NetWorkType netWorkType;

    public NetWorkConfig netWorkConfig;

    public DefaultNetWorkComponents(NetWorkConfig netWorkConfig) {
        this.netWorkType = netWorkType;
        this.netWorkConfig = netWorkConfig;
    }
}
