package com.raif.testtaskf.service;


import com.raif.testtaskf.dao.SocksRepository;
import com.raif.testtaskf.entity.Socks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocksServiceImpl implements SocksService{
    @Autowired
    private SocksRepository socksRepository;

    @Override
    public void saveSocks(Socks socks) {
        socksRepository.save(socks);
    }

    @Override
    public Socks getSocks(int cottonPart, String color) {
        Socks socks=socksRepository.findByCottonPartEqualsAndColorEquals(cottonPart, color);
        return socks;
    }

    @Override
    public Integer getSumOfSocksWithCottonPartGreater(int cottonPart, String color) {
        Integer sumOfSocks=socksRepository.findSumOfSocksWithCottonPartGreaterThan(cottonPart, color);
        return sumOfSocks;
    }

    @Override
    public Integer getSumOfSocksWithCottonPartLess(int cottonPart, String color) {
        Integer sumOfSocks=socksRepository.findSumOfSocksWithCottonPartLessThan(cottonPart, color);
        return sumOfSocks;
    }

    @Override
    public void deleteSocks(int id) {
        socksRepository.deleteById(id);
    }
}
