package com.reservation.handler;

import com.reservation.domain.Reservation;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Reservation.class)
public class ReservationRepositoryHandler {

    @HandleAfterCreate
    public void afterCreate(Reservation res) {
        System.out.println("afterCreate");
    }

    @HandleAfterSave
    public void afterSave(Reservation res) {
        System.out.println("afterSave");
    }

    @HandleAfterDelete
    public void afterDelete(Reservation res) {
        System.out.println("afterDelete");
    }
}
