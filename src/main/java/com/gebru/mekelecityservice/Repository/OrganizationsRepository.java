package com.gebru.mekelecityservice.Repository;

import com.gebru.mekelecityservice.Model.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organizations,Long> {
}
