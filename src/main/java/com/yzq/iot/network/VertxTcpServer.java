package com.yzq.iot.network;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author YuanZiQiang
 * @Description TCP服务端组件
 * @Date 2022/7/13
 **/
@Slf4j
public class VertxTcpServer extends DefaultNetWorkComponents {

    private final Vertx vertx;

    private NetServer netServer;

    private long aliveTime;

    private List<TcpClient> clients = new ArrayList<>();

    public VertxTcpServer(NetWorkConfig netWorkConfig, Vertx vertx) {
        super(netWorkConfig);
        this.vertx = vertx;
    }

    @Override
    public void init() {
        netServer = vertx.createNetServer();
        netServer.connectHandler(this::accept);
        netServer.listen(netWorkConfig.createSocketAddress(), result -> {
            if (result.succeeded()) {
                log.info("tcp server startup on {}", result.result().actualPort());
            } else {
                log.error("startup tcp server error", result.cause());
            }
        });


    }

    /**
     * @param netSocket
     */
    public void accept(NetSocket netSocket) {
        netSocket.handler(buffer -> {
                    // 判断是否发生拆包
                    // 调用消息解析
                    // 转发事件
                    aliveTime = System.currentTimeMillis();
                    log.info("收到设备消息：{}", new String(buffer.getBytes(), StandardCharsets.UTF_8));
                }
        );
        netSocket.closeHandler(v -> log.info("客户端连接断开"));
    }

    @Override
    public void shutdown() {
        netServer.close();
    }

    @Override
    public void reload() {
        this.shutdown();
        this.init();
    }

    @Override
    public NetWorkType getNetWorkType() {
        return NetWorkType.TCP_SERVER;
    }
}
