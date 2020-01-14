package com.xlccc.config.props;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @ClassName ZkWatcher
 * @Description TODO
 * @Author Linkp
 * @Date 2020/1/15 1:59 AM
 **/
public class ZkWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("ZkWatcher.process------" + watchedEvent);


    }
}
