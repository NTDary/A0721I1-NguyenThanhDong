package com.casestudy.repository.contract;

import com.casestudy.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService, Long> {
}
