package com.raif.testtaskf.controller;


import com.raif.testtaskf.entity.Socks;
import com.raif.testtaskf.exception_handling.NoSuchSocks;
import com.raif.testtaskf.exception_handling.UnrecognizedOperation;
import com.raif.testtaskf.projectresources.ComparisonOperation;
import com.raif.testtaskf.projectresources.Messanger;
import com.raif.testtaskf.service.SocksService;
import com.raif.testtaskf.service.ValidationService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SocksController {
    @Autowired
    private SocksService socksService;
    @Autowired
    private ValidationService validationService;

    @PostMapping(path = "/socks/income")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Messanger> socksIncome(@RequestBody @Valid Socks receivedSocks){
        validationService.doesColorExist(receivedSocks.getColor());
        Socks socks=socksService.getSocks(receivedSocks.getCottonPart(), receivedSocks.getColor());
        if(socks!=null){
            socks.setQuantity(receivedSocks.getQuantity()+socks.getQuantity());
            socksService.saveSocks(socks);
            return new ResponseEntity<>(new Messanger("The quantity of socks with " + socks.getColor() +
                    " color is " + socks.getQuantity() + " for now."), HttpStatus.OK);
        }
        else {
            socksService.saveSocks(receivedSocks);
            return new ResponseEntity<>(new Messanger("Socks with " + receivedSocks.getColor() +
                    " color and quantity " + receivedSocks.getQuantity() + " was added."), HttpStatus.OK);
        }
    }

    @PostMapping(path = "/socks/outcome")
    public ResponseEntity<Messanger> socksOutcome(@RequestBody @Valid Socks takenSocks){
        validationService.doesColorExist(takenSocks.getColor());
        Socks socks=socksService.getSocks(takenSocks.getCottonPart(), takenSocks.getColor());
        if(socks!=null){
            int sumOfSocks=socks.getQuantity()-takenSocks.getQuantity();
            if(sumOfSocks<=0){
                socksService.deleteSocks(socks.getId());
                return new ResponseEntity<>(new Messanger("All of socks with " + socks.getColor() +
                        " color and quantity = " + socks.getQuantity() + " was removed."), HttpStatus.OK);
            }
            else {
                socks.setQuantity(sumOfSocks);
                socksService.saveSocks(socks);
                return new ResponseEntity<>(new Messanger("The quantity of socks with " + socks.getColor() +
                        " color is " + socks.getQuantity() + " for now."), HttpStatus.OK);
            }
        }
        else throw new NoSuchSocks("There is no socks with these parameters");
    }

    @GetMapping(path = "/socks")
    public ResponseEntity<Integer> countOfSocks(@RequestParam(name = "color") @NotNull String color,
                                                @RequestParam(name = "operation") String operation,
                                                @RequestParam(name = "cottonPart") int cottonPart) {
        validationService.doesColorExist(color);
        if (operation.equals(ComparisonOperation.moreThan.toString())) {
            Integer sumOfSocks=socksService.getSumOfSocksWithCottonPartGreater(cottonPart,color);
            validationService.doSocksExist(sumOfSocks);
            return new ResponseEntity<>(sumOfSocks,HttpStatus.OK);
        }
        else if (operation.equals(ComparisonOperation.lessThan.toString())) {
            Integer sumOfSocks=socksService.getSumOfSocksWithCottonPartLess(cottonPart,color);
            validationService.doSocksExist(sumOfSocks);
            return new ResponseEntity<>(sumOfSocks,HttpStatus.OK);
        }
        else if(operation.equals(ComparisonOperation.equals.toString())) {
            Socks socks=socksService.getSocks(cottonPart,color);
            validationService.doSocksExist(socks);
            return new ResponseEntity<>(socks.getQuantity(),HttpStatus.OK);
        }
        else throw new UnrecognizedOperation("Your operation isn`t recognized.");
    }
}
