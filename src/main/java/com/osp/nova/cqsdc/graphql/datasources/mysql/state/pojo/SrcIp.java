package com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "stats_indicator_attack_src")
public class SrcIp {

    @Id
    private String attackSrcIp;

    private String attackOs;

    private String tools;

    private Integer isOnlyScan;

    private Double attackFrequency;

    private Integer attackTimes;

    private String attackType;

    private Integer isAttackSuccess30d;

    private Integer isSimulate30d;

    private Integer isMaterial30d;

    private String mostAttackType;

    private Integer isAttackSuccess24h;

    private Integer isSimulate24h;

    private Integer isMaterial24h;

    private Date updateTime;

    private Double attackedFrequency7d;

    private Date createTime;
}
