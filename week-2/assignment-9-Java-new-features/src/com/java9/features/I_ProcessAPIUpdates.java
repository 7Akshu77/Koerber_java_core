package com.java9.features;

public class I_ProcessAPIUpdates {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();//current thread
        ProcessHandle.Info info = ph.info();// to get the info
        info.user().get();// user info
        info.command().get();// command that was used
        info.startInstant().get();// gets the start time
        info.totalCpuDuration().get();// gets the cpu utilisation duration
    }
}
