package com.raif.testtaskf.service;


import com.raif.testtaskf.entity.Socks;

public interface SocksService {
    public void saveSocks(Socks socks);
    public Socks getSocks(int cottonPart, String color);
    public Integer getSumOfSocksWithCottonPartGreater(int cottonPart, String color);
    public Integer getSumOfSocksWithCottonPartLess(int cottonPart, String color);
    public void deleteSocks(int id);
}
