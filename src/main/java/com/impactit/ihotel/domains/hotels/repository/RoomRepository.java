package com.impactit.ihotel.domains.hotels.repository;

import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
