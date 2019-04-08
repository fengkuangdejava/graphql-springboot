package com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository;

import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.SrcIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface SrcIpRepository extends JpaRepository<SrcIp, String>, JpaSpecificationExecutor<SrcIp>, Serializable {
}
