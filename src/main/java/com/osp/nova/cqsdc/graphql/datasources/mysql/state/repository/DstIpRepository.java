package com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository;

import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.DstIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
public interface DstIpRepository extends JpaRepository<DstIp, String>, JpaSpecificationExecutor<DstIp>, Serializable {
}
