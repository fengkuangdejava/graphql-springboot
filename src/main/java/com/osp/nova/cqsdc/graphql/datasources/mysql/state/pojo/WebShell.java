package com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "stats_indicator_webshell")
public class WebShell {

    @Id
    private String baseurl;

    private Integer backdoorTimes;

    private String backdoorPassword;

    private String attackSrcIp;

    private String attackIps;

    private Integer attackIpsNumber;

    private Date updateTime;

    private String backdoorUrl;
}
