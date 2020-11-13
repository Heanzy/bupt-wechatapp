package com.buptcc.wechatapp.utils;

import com.mysql.jdbc.TimeUtil;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PreSolve {

    private static ThreadPoolExecutor executor;

    static {
        //根据实际情况创建线程池
        executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024) , new ThreadPoolExecutor.AbortPolicy());
    }

    public static boolean exec(String cname, String pname) throws IOException, InterruptedException {
        String cmds ="matlab -nosplash -nodesktop -r \"generateImageMat('"+pname+"','"+cname+"')\"";
        Process process = Runtime.getRuntime().exec(cmds);

        //消费正常日志
        clearStream(process.getInputStream());
        //消费错误日志
        clearStream(process.getErrorStream());
        System.out.println("执行到这");
        //i为返回值，判断是否执行成功
        process.waitFor(4000, TimeUnit.MILLISECONDS);

        return true;
    }

    private static void clearStream(InputStream stream) {
        //处理buffer的线程
        executor.execute(new Runnable() {
            @Override
            public void run() {

                String line = null;

                try (BufferedReader in = new BufferedReader(new InputStreamReader(stream));) {
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        });
    }
} 

 

