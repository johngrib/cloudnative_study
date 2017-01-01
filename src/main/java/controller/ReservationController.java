package controller;

import entity.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @RequestMapping("/reservation")
    public ResponseEntity<Object> reservation() {
        final Reservation res = new Reservation(1l, "test");
        return ResponseEntity.ok(res);
    }
}
