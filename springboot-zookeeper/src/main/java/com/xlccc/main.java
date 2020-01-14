package com.xlccc;

import com.xlccc.Utils.ZookeeperUtil;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @ClassName main
 * @Description TODO
 * @Author Linkp
 * @Date 2020/1/15 2:22 AM
 **/
public class main
{
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
            ZookeeperUtil zookeeperUtil = new ZookeeperUtil();
//            zookeeperUtil.ZkConnection();

            zookeeperUtil.ZkConnection();
//            zookeeperUtil.getAll();
//
//
//            zookeeperUtil.create();
////
//            zookeeperUtil.getData();
//
//            zookeeperUtil.update();
////
//            zookeeperUtil.getData();
    }
}
