package me.egorich.lobbyplugin.Utils.Pinger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Pinger {
    private InetAddress inet;
    private Integer port;
    public Pinger(String ip, Integer port) throws UnknownHostException {
        inet = InetAddress.getByName(ip);
        this.port = port;
    }

    public boolean isOnline() throws IOException {
        return inet.isReachable(port);
    }
}
