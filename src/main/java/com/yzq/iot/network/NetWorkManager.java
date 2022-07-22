package com.yzq.iot.network;

import io.vertx.core.Vertx;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @Author YuanZiQiang
 * @Description //TODO
 * @Date 2022/7/13
 **/
@Component
public class NetWorkManager {

    @PostConstruct
    public void init(){
        NetWorkConfig netWorkConfig = new NetWorkConfig();
        netWorkConfig.setPort(6000);
        netWorkConfig.setKeepAliveTime(6000);
        VertxTcpServer vertxTcpServer = new VertxTcpServer(netWorkConfig,Vertx.vertx());
        vertxTcpServer.init();
    }
}
