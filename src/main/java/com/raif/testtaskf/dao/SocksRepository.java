package com.raif.testtaskf.dao;

import com.raif.testtaskf.entity.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SocksRepository extends JpaRepository<Socks, Integer> {
    public Socks findByCottonPartEqualsAndColorEquals(int cottonPart, String color);
    @Query(value = "SELECT SUM(quantity) FROM warehouse WHERE color=:color AND cotton_part>:cottonPart", nativeQuery = true)
    public Integer findSumOfSocksWithCottonPartGreaterThan(@Param("cottonPart") int cottonPart, @Param("color") String color);
    @Query(value = "SELECT SUM(quantity) FROM warehouse WHERE color=:color AND cotton_part<:cottonPart", nativeQuery = true)
    public Integer findSumOfSocksWithCottonPartLessThan(@Param("cottonPart") int cottonPart, @Param("color") String color);
    public void deleteById(int id);
}
