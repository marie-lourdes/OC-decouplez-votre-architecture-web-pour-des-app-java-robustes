package com.airbusiness.airbusinessmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airbusiness.airbusinessmvc.entities.MaintenanceIssue;


@Repository
public interface MaintenanceRepository extends CrudRepository<MaintenanceIssue, Long>   {
}
