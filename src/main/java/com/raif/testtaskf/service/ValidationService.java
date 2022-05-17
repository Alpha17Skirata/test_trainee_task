package com.raif.testtaskf.service;

import com.raif.testtaskf.entity.Socks;

public interface ValidationService {
    public boolean doesColorExist(String color);
    public boolean doSocksExist(Integer sumOfSocks);
    public boolean doSocksExist(Socks socks);
}
