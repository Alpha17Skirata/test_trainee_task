package com.raif.testtaskf.service;

import com.raif.testtaskf.entity.Socks;
import com.raif.testtaskf.exception_handling.UnknownColor;
import com.raif.testtaskf.exception_handling.NoSuchSocks;
import com.raif.testtaskf.projectresources.Color;
import org.springframework.stereotype.Service;


@Service
public class ValidationServiceImpl implements ValidationService{
    @Override
    public boolean doesColorExist(String color) {
        try {
            Color.valueOf(color);
            return true;
        }
        catch (IllegalArgumentException e){
            throw new UnknownColor("Unknown color. Expected: black, blue, white, yellow, grey");
        }
    }

    @Override
    public boolean doSocksExist(Integer sumOfSocks) {
        if(sumOfSocks==null){
            throw new NoSuchSocks("There is no socks with these parameters");
        }
        else return true;
    }

    @Override
    public boolean doSocksExist(Socks socks) {
        if(socks==null){
            throw new NoSuchSocks("There is no socks with these parameters");
        }
        else return true;
    }
}
