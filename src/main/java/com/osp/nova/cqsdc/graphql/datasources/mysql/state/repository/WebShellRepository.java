package com.osp.nova.cqsdc.graphql.datasources.mysql.state.repository;

import com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo.WebShell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface WebShellRepository extends JpaRepository<WebShell, String>, JpaSpecificationExecutor<WebShell>, Serializable {
}
