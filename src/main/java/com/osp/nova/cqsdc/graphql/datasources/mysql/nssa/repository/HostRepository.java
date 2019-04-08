package com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.repository;

import com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.pojo.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface HostRepository extends JpaRepository<Host, String>, JpaSpecificationExecutor<Host>, Serializable {
    Host findByIp(String ip);
}
