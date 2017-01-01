package com.example;

import controller.ReservationController;
import entity.Reservation;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;

public class ReservationTests {

	@Test
	public void contextLoads() {
		ReservationController cont = new ReservationController();
		ResponseEntity<Object> res = cont.reservation();

        HttpStatus stat = res.getStatusCode();

        assertEquals("stat code가 200이어야 한다.", 200, stat.value());

		Reservation r = (Reservation) res.getBody();
        assertEquals("name이 test여야 한다.", "test", r.getName());
	}

}
