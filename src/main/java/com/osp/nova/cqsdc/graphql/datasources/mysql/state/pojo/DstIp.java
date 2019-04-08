package com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stats_indicator_attacked_dst")
public class DstIp {

    @Id
    private String attackDstIp;

    private Integer isBackdoor30d;

    private Integer isLoophole30d;

    private Integer attackedIpsNumber;

    private Integer attackedLoopholesTimes;

    private Integer attackedXss;

    private Integer attackedCommand;

    private Integer attackedSqlInjection;

    private Integer webshellNumber;

    private Integer attackedWebshellNumber;

    private Integer isAttackedSuccess30d;

    private Integer otherAttackedTimes;

    private Double attackedFrequency;

    private Integer attackedTimes;

    private Integer isOnlyScaned30d;

    private Integer isBackdoor24h;

    private Integer isLoophole24h;

    private Integer isAttackedSuccess24h;

    private Integer isOnlyScaned24h;

    private Date updateTime;

    private Double attackedFrequency7d;

    private Date createTime;
}
