package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Date;

@Repository("weatherRepository")
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query("delete from Weather, Location where  latitude=:lat and longitude=:lon and dateRecorded between :start and :end")
    long deleteByDateAndLocation(@Param("start") Date start, @Param("end") Date end, @Param("lat") Float lat, @Param("lon") Float lon);

    @Query("SELECT temperature from Weather where dateRecorded between :start and :end")
    Weather getByDate(@Param("start") Date start, @Param("end") Date end);

    @Query("select cityName from Location where latitude=:lat and longitude=:lon")
    Weather getByLocation( @Param("lat") Float lat, @Param("lon") Float lon);



}
