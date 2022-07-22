package com.yzq.iot.network;

import io.vertx.core.net.SocketAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * @Author YuanZiQiang
 * @Description 网络组件配置
 * @Date 2022/7/22
 **/
@Getter
@Setter
public class NetWorkConfig {

    /**
     * 组件保活时间
     */
    private long keepAliveTime;

    /**
     * 端口
     */
    private int port;

    /**
     * host
     */
    private String host;

    /**
     *
     * @return
     */
    public SocketAddress createSocketAddress() {
        if (!StringUtils.hasLength(host)) {
            host = "localhost";
        }
        return SocketAddress.inetSocketAddress(port, host);
    }
}
