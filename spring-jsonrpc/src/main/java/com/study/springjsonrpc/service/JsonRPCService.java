package com.study.springjsonrpc.service;

public interface JsonRPCService {
    String getUserById(String id);
    void addUser(String id, String name, String password);
    String getServerTime();
}
